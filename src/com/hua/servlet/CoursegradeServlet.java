package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.StudentBasicInforDAO;
import com.hua.dao.StudentGradeDAO;
import com.hua.entity.CriterStudent;
import com.hua.entity.GradeAnalysisResult;
import com.hua.entity.StudentBasicInformation;
import com.hua.entity.StudentGrade;
import com.hua.entity.User;
import com.hua.impl.StudentBasicInforDAOImpl;
import com.hua.impl.StudentGradeDAOIpml;
/**
 * ѧ���ɼ�servlet
 * 1.����Ա��ѯѧ���ɼ�
 * 2.��ȡѧ���ɼ���ͳ�Ʒ����������ܷ֣�ƽ���֣�����ȵ�
 * 3.ѧ���û���ѯ�Լ��ĳɼ�
 * @author hua
 *
 */
@WebServlet("*.grade")
public class CoursegradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.��ȡServletPath��/addUser.do
		String servletPath = request.getServletPath();
		//2.ȥ�� / �� .do ���õ�������addUser�������ַ���
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
	
	//�ɼ�ͳ�Ʒ�����������㼨��,���������ȵ�
	@SuppressWarnings("unused")
	private void gradeAnalysis(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		//��ȡҪ��ѯ������ѧ������Ϣ���Ž�List��
		List<StudentBasicInformation> students = getStudent(request, response);
		
		//��ȡÿһλѧ�������Ӧ�����еĳɼ�����Ϊ��ֵ�Դ���map��
		Map<StudentBasicInformation,List<StudentGrade>> map = getAllGradeMap(students, yearTerm);
		//��ȡÿһλѧ���ĳɼ�ͳ�Ʒ������
		Map<StudentBasicInformation, GradeAnalysisResult> results = getAnalysisResult(map);
		//��ÿһλѧ���ĳɼ������������session��
		session.setAttribute("results", results);
		//�ض���jsp��ʾҳ��
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/acdemic/grademanagement/gradeanalysis.jsp");
	}
	
	//��ȡ�ɼ�����������ѽ������һ��������
	private Map<StudentBasicInformation, GradeAnalysisResult> getAnalysisResult(
			Map<StudentBasicInformation, List<StudentGrade>> map) {
		//List results = new ArrayList();
		Map<StudentBasicInformation, GradeAnalysisResult> GradeMap = new HashMap<>();
		
		for(Map.Entry<StudentBasicInformation,List<StudentGrade>> entry : map.entrySet()){
			StudentBasicInformation stu = entry.getKey();
			List<StudentGrade> studentGrades = entry.getValue();
			int courseCount = studentGrades.size();  //��ȡ�γ�����
			if(courseCount != 0){
				int score = getScore(studentGrades);  //��ȡ�ܷ�
				double averScore = score / courseCount;    //ƽ����
				double gradePoint = getGradePoint(studentGrades);   //ƽ��ѧ�ּ���
				double averCreditGrade = (gradePoint + 5) * 10;  //ƽ��ѧ�ֳɼ�
				
				//ʹƽ���֡�ƽ��ѧ�ּ��㡢ƽ��ѧ�ֳɼ������λС�����������룩
				 DecimalFormat df = new DecimalFormat("#.00");
				 
				GradeAnalysisResult gradeAnalysisResult = new GradeAnalysisResult(stu.getStudentId(),
						courseCount, score, df.format(gradePoint), df.format(averCreditGrade), df.format(averScore));
				
				GradeMap.put(stu, gradeAnalysisResult);	
			}
		}
		
		return GradeMap;
	}
	
	//��ƽ��ѧ�ּ���
	private double getGradePoint(List<StudentGrade> studentGrades) {
		StudentGrade studentGrade = null;
		double credit = 0.0,sum = 0.0;
		
		Iterator<StudentGrade> iter = studentGrades.iterator();
		while(iter.hasNext()){
			studentGrade= iter.next();
			sum = sum + studentGrade.getGradePoint() * studentGrade.getCredit();
			credit = credit + studentGrade.getCredit();
			
		}
		
		return sum / credit;
	}
	
	private int getScore(List<StudentGrade> studentGrades) {
		int score = 0;
		
		Iterator<StudentGrade> iter = studentGrades.iterator();
		StudentGrade studentGrade = null;
		while(iter.hasNext()){
			studentGrade= iter.next();
			score = score + studentGrade.getScore();		
		}
		return score;
	}

	//����Ա��ѯѧ���ɼ�
	@SuppressWarnings("unused")
	private void deanQuery(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		
		List<StudentBasicInformation> students = getStudent(request, response);
		
		
		Map<StudentBasicInformation,List<StudentGrade>> map = getAllGradeMap(students, yearTerm);
		
		session.setAttribute("map", map);
		
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/acdemic/grademanagement/gradequery.jsp");
	}
	
	

	private Map<StudentBasicInformation, List<StudentGrade>> getAllGradeMap(
			List<StudentBasicInformation> students, String yearTerm) {
		Map<StudentBasicInformation,List<StudentGrade>> map = new HashMap<>();
		StudentGradeDAO sgd = new StudentGradeDAOIpml();
		
		for(StudentBasicInformation sbi : students){
			List<StudentGrade> studentGrades = sgd.getAllWithYearTerm(sbi.getStudentId(),yearTerm);
			map.put(sbi, studentGrades);
		}
		return map;
	}
	
	//��ȡ������ѯ��������ѧ����Ϣ
	private List<StudentBasicInformation> getStudent(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String academy = request.getParameter("academy");  //ѧԺ
		String profession = request.getParameter("profession");
		String className = request.getParameter("className");
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		
		CriterStudent cs = new CriterStudent(academy, profession, className, studentName, studentId);
		StudentBasicInforDAO sbi = new StudentBasicInforDAOImpl();
		
		return sbi.getForListWithCriterStudent(cs);
	}
	
	//ѧ���û���ѯ�Լ��ĳɼ�
	@SuppressWarnings("unused")
	private void studentQuery(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		List<StudentGrade> studentGrades = getAllcourseGradeList(user);
		
		session.setAttribute("studentGrades", studentGrades);
		
		response.sendRedirect(request.getContextPath() + "/student/informationinquiry/coursegrade.jsp");
	}
	
	private List<StudentGrade> getAllcourseGradeList(User user) {
		StudentGradeDAO sgd = new StudentGradeDAOIpml();
		return sgd.getAllCourseGrade(Long.parseLong(user.getUsername()));
	}



}
