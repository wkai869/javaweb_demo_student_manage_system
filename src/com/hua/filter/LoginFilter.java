package com.hua.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;


@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/loginChangeServlet" })
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		//��ȡ�������username��password
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		//��ֹ�ظ��ύ
		if(!repeatSubmit(request, response)) return;
		
		if(username == "" && password == ""){
			String message = "�˺ź����벻��Ϊ��";
			session.setAttribute("message", message);
			//�ض���ص���¼ҳ��
			response.sendRedirect("login/login.jsp");	
		}else{
			if(!check(username,password)){
				//����ƥ��ʧ�ܺ󷵻ص�¼ҳ�沢����һ����Ϣ�����������������������
				String message = "�˺Ż����벻��ȷ������������";
				session.setAttribute("message", message);
				
				session.setAttribute("username", username);
				//�ض���ص���¼ҳ��
				response.sendRedirect("login/login.jsp");
				return;
			}
			filterChain.doFilter(request, response);
			return;
		}
		
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

	private boolean check(String username, String password) {
		//�������ݿ��ѯ
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = userDAOImpl.get(username);
		if(user != null){
			if(user.getPassword().equals(password)){
				return true;
			}	
		}
		return false;
	}
 

}
