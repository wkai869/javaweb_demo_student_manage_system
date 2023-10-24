package com.hua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;

@WebServlet("/findPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//��ȡ�������username��idCard
		String username = request.getParameter("username");
		String idCard = request.getParameter("idCard");		
		
		//��ֹ�ظ��ύ
		if(!repeatSubmit(request, response)) return;
		
		if(username == "" && idCard == ""){
			String message = "�˺ź�ƾ�ݲ���Ϊ��";
			session.setAttribute("message", message);	
		}else{
			User user = get(username);
			if(user != null && (!user.getFindMMproof().equals(idCard))){
				//����ƥ��ʧ�ܺ󷵻ص�¼ҳ�沢����һ����Ϣ�����������������������
				String message = "�˺Ż�ƾ�ݲ���ȷ������������";
				session.setAttribute("message", message);
					
				session.setAttribute("username", username);
			}else{
				//��������
				String newPassword = resetPassword(user);
				session.setAttribute("message", "��������Ϊ��" + newPassword);
			}
			
		}
		//�ض���ص���¼ҳ��
		response.sendRedirect("login/findpassword.jsp");
		
	}

	private String resetPassword(User user) {
		String newPassword = "000000";
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		user.setPassword(newPassword);
		
		userDAOImpl.update(user);
		
		return newPassword;
		
	}

	private boolean repeatSubmit(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		Object token = session.getAttribute("token");
		String tokenVlaue = request.getParameter("token");
		
		if(token != null && token.equals(tokenVlaue)){
			session.removeAttribute("token");
			return true;
		}else{
			response.sendRedirect(request.getContextPath() + "/repeatsubmit.jsp");
			return false;
		}
		
	}

	private User get(String username) {
		//�������ݿ��ѯ
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = userDAOImpl.get(username);
		if(user != null){
			return user;
		}
		return null;
	}

}
