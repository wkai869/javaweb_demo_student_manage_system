package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.LevelExamDAO;
import com.hua.dao.LevelExamListDAO;
import com.hua.entity.LevelExam;
import com.hua.entity.LevelExamList;
import com.hua.entity.User;
import com.hua.impl.LevelExamDAOImpl;
import com.hua.impl.LevelExamListDAOImpl;

@WebServlet("*.apply")
public class LevelExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LevelExamDAO led = new LevelExamDAOImpl();
	LevelExamListDAO lel = new LevelExamListDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡServletPath
		String servletPath = request.getServletPath();
		//2.ȥ�� / �� .apply
		String methodName = servletPath.substring(1, servletPath.length() - 6);
				
		try {
			//3.���÷����ȡmethodName��Ӧ�ķ���
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//4.���÷�����ö�Ӧ�ķ���
			method.invoke(this, request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}		
	}
	
	//��ѯѡ�޿γ���Ϣ
	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String yearTerm = request.getParameter("yearTerm");
		
		Map<LevelExam, String> map = new HashMap<>();
		List<LevelExam> levelExams = led.getAllWithYearTerm(yearTerm);
		//��ѯ��ѧ���ѱ����Ŀγ�
		for(LevelExam levelExam: levelExams){
			LevelExamList levelExamList = new LevelExamList(user.getUsername(), levelExam.getCourseId());
			if(lel.get(levelExamList) != null){
				map.put(levelExam, "��");
			}else{
				map.put(levelExam, "��");
			}
		}
		session.setAttribute("map", map);
		
		response.sendRedirect(request.getContextPath() + "/student/courseselect/levelexamapply.jsp");
	}
	
	//ѧ������ѡ�޿γ�
	@SuppressWarnings("unused")
	private void apply(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String courseId = request.getParameter("courseId");
	
		
		LevelExamList levelExamList = new LevelExamList(user.getUsername(), courseId);
		//�жϸÿγ��Ƿ��ѱ�������ֹ�ر���
		if(lel.get(levelExamList) != null){
			session.setAttribute("message", "�ÿγ��ѱ����������ظ�����!");
			
			response.sendRedirect(request.getContextPath() + "/student/courseselect/levelexamapply.jsp");
			
			return;
		}
		lel.insert(levelExamList);
		
		session.setAttribute("message", "�����ɹ�!");
		
		response.sendRedirect(request.getContextPath() + "/student/courseselect/levelexamapply.jsp");
	}
}
