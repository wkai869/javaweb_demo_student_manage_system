package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hua.dao.UserDAO;
import com.hua.entity.CriterUser;
import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;

@WebServlet("*.do")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = new UserDAOImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡServletPath��/addUser.do
		String servletPath = request.getServletPath();
		//2.ȥ�� / �� .do ���õ�������addUser�������ַ���
		String methodName = servletPath.substring(1, servletPath.length() - 3);
		
		try {
			//3.���÷����ȡmethodName��Ӧ�ķ���
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//4.���÷�����ö�Ӧ�ķ���
			method.invoke(this, request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void addUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//1.��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String findMMproof = request.getParameter("findMMproof");
		
		//2.����username�Ƿ��Ѿ���ռ�ã�	
		//2.1 ����userDAO��getCountWithName(String username)��ȡusername�����ݿ����Ƿ����
		long i = userDAO.getCountWithName(username);
		//2.2 ������ֵ����0������Ӧadduser.jspҳ��
		//ͨ��ת���ķ�ʽ����Ӧadduser.jsp
		if(i > 0){
			//2.2.1 Ҫ����adduser.jspҳ����ʾһ��������Ϣ���û���username�Ѿ���ռ�ã�������ѡ��
			//��request�з���һ������message���û���username�Ѿ���ռ�ã�������ѡ�� 
			//��ҳ����ͨ��request.getAttribute("message")�ķ�ʽ����ʾ
			String message = "�û���" +username +"�Ѿ���ռ�ã�������ѡ��";
			request.setAttribute("message", message);
			//2.2.2 adduser.jsp�ı����Ի��ԡ�
			request.getRequestDispatcher("/administrator/adduser.jsp").forward(request, response);
			//2.2.3 �����취��return
			return ;
		}
			
		//3.�ѱ�������װΪһ��User����user
		User user = new User(username, password, name, identity, findMMproof,null,null);
		//4.����userDAO��insert(User user)ִ�б������
		userDAO.insert(user);
		
		String message = "��ӳɹ�";
		request.setAttribute("message", message);
		//5 adduser.jsp�ı����Ի��ԡ�
		request.getRequestDispatcher("/administrator/adduser.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		
		CriterUser user = new CriterUser(username, name, identity);
		
		//1.ֱ�ӵ���CustomerDAO��getAll()�õ�Customer�ļ���
		List<User> users = userDAO.getForListWithCriterCustomer(user);
		
		//2.��Customer�ļ��Ϸ���request��
		request.setAttribute("users", users);
		
		//3.ת��ҳ�浽adminuser.jsp(����ʹ���ض���)
		request.getRequestDispatcher("/administrator/adminuser.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String username = request.getParameter("username");		
		
		userDAO.delete(username);
				
		//�ض���queryҳ��
		response.sendRedirect("query.do");
	}
	
	@SuppressWarnings("unused")
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//1.��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String findMMproof = request.getParameter("findMMproof");
		String oldUsername = request.getParameter("oldUsername");
		//2.����username�Ƿ��Ѿ���ռ��
		//2.1�Ƚ�username��oldUsername�Ƿ���ͬ������ͬ˵��name����
		//������ͬ������userDAO��getCountWithName(String username)��ȡusername�����ݿ����Ƿ����
		if(!oldUsername.equals(username)){
			long count = userDAO.getCountWithName(username);
			//2.2 ������ֵ����0������Ӧupdateuser.jspҳ��
			//ͨ��ת���ķ�ʽ����Ӧupdateuser.jsp
			if(count > 0){				
				//2.2.1 Ҫ����updateuser.jspҳ����ʾһ��������Ϣ���û���username�Ѿ���ռ�ã�������ѡ��
				//��request�з���һ������message���û���username�Ѿ���ռ�ã�������ѡ�� 
				//��ҳ����ͨ��request.getAttribute("message")�ķ�ʽ����ʾ
				String message = "�û���" +username +"�Ѿ���ռ�ã�������ѡ��";
				request.setAttribute("message", message);
				//2.2.2 updatecustomer.jsp�ı����Ի��ԡ�
				//address, phone ��ʾ�ύ�����µ�ֵ����username��ʾoldName�����������ύ��username
				request.getRequestDispatcher("/administrator/updateuser.jsp").forward(request, response);
				
				//2.2.3 �����취��return
				return ;
			}
		}
		
		
		
		//3.�ѱ�������װΪһ��User����user
		User user = new User(username, password, name, identity, findMMproof, null, null);
		//4.����userDAO��update(User user)ִ�и��²���
		userDAO.update(user);
		//5.�ض��򵽲�ѯ��ʾadminuser.jspҳ��
		response.sendRedirect("query.do");
	}
	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String forwardPath = "/error.jsp";
		
		//1.��ȡ�������id
		String username = request.getParameter("username");
		
		//2.����UserDAO��userDAO.get(username)��ȡ��username��Ӧ��User����
		try {
			User user = userDAO.get(username);
			if(user != null){
				forwardPath = "/administrator/updateuser.jsp";
				//3.��user����request��
				request.setAttribute("user", user);
			}
		} catch (Exception e) {
			
		}
		//4.��Ӧupdatecustomer.jspҳ�棺ת��		
		request.getRequestDispatcher(forwardPath).forward(request, response);
		
		
	}
}
