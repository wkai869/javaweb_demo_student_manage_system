package com.hua.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hua.entity.User;

/**
 *���ʽ�ʦ�û��µ�����ҳ��Ĺ�����
 * ��session�е�user��ʧ������Ҫ���µ�¼
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, urlPatterns = { "/administrator/*" })
public class TeacherFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		User user = (User) request.getSession().getAttribute("user");
		
		if(user == null){
			String message = "�˺��ѹ��ڣ������µ�¼";
			request.getSession().setAttribute("message", message);	
			//�ض���ص���¼ҳ��
			response.sendRedirect(request.getContextPath() + "/login/login.jsp");
		}
		
		filterChain.doFilter(request, response);
	}

    
}
