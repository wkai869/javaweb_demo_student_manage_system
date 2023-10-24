package com.hua.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��¼ʱ���� ��֤���Ƿ�һ��
 * @author hua
 *
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/loginChangeServlet" })
public class LoginCheckCodeFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//1. ��ȡ�������: CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
				
		//2. ��ȡ session �е� CHECK_CODE_KEY ����ֵ
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
				
		//3. �ȶ�. ���Ƿ�һ��, ��һ��˵����֤����ȷ, ����һ��, ˵����֤�����
		if(!(paramCode != null && paramCode.equalsIgnoreCase(sessionCode))){
			request.getSession().setAttribute("message", "��֤�벻һ��!");
			request.getSession().setAttribute("username", request.getParameter("username"));
			
			response.sendRedirect(request.getContextPath() + "/login/login.jsp");
			return;
		}
				
		filterChain.doFilter(request, response);
		
	}
	
}
