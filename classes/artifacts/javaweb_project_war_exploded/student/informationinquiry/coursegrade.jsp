<%@page import="java.util.List"%>
<%@page import="com.hua.entity.StudentGrade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
		div {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
			margin: 20px auto;
			padding: 20px;
			width: 95%;
		}
		body {
			font-family: Arial, sans-serif;
			background-color: #007BFF;
			color: #000000;
		}
		h1 {
			color: #333;
		}
		a {
			text-decoration: none;
			color: #007bff;
		}
		a:hover {
			text-decoration: underline;
		}
		table {
			width: 100%;
			border-collapse: collapse;
			margin-top: 20px;
		}
		th, td {
			padding: 8px;
			text-align: left;
			border-bottom: 1px solid #ddd;
		}
		th {
			background-color: #f2f2f2;
		}
	</style>
</head>
<body>
<h1>${sessionScope.user.name },您好！</h1>
<div>
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
	<a href="<%=request.getContextPath()%>/login/login.jsp">注销</a>
</div>
<br><br>
<a href="<%=request.getContextPath() %>/student/informationinquiry/informationinquiry.jsp">返回上一步</a>
<div>
	<h3>课程成绩</h3>
</div>
<div>
<table border="2" cellpadding="0" cellspacing="0">
	<tr>
		<th>学年学期</th>
		<th>学号</th>
		<th>学生姓名</th>
		<th>课程编号</th>
		<th>课程名称</th>
		<th>成绩</th>
		<th>绩点</th>
		<th>学分</th>
		<th>课程大类</th>
		<th>修读方式</th>
		<th>考试性质</th>
		<th>成绩方式</th>
		<th>有效</th>
		<th>备注</th>
	</tr>
	<%
		List<StudentGrade> studentGrades = (List<StudentGrade>)session.getAttribute("studentGrades");
	%>
	<%
		for(StudentGrade student : studentGrades){
	%>
	<tr>
		<td><%= student.getYearTerm()%></td>
		<td><%= student.getStudentId()%></td>
		<td><%= student.getStudentName()%></td>
		<td><%= student.getCourseId()%></td>
		<td><%= student.getCourseName()%></td>
		<td><%= student.getScore() %></td>
		<td><%= student.getGradePoint() %></td>
		<td><%= student.getCredit() %></td>
		<td><%= student.getCourseClass() %></td>
		<td><%= student.getStudyWay() %></td>
		<td><%= student.getExamWay() %></td>
		<td><%= student.getGradeWay() %></td>
		<td><%= student.getEffectivity() %></td>
		<td><%= student.getRemarks() %></td>
	</tr>
	<%
		}
	%>
</table>
</div>
</body>
</html>
