<%@page import="com.hua.entity.StudentBasicInformation"%>
<%@page import="com.hua.entity.LevelExamination"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学籍管理系统</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #007BFF;
			color: #000000;
		}
		h1 {
			color: #333;
		}
		table {
			width: 100%;
			border-collapse: collapse;
		}
		th, td {
			padding: 8px;
			text-align: left;
			border-bottom: 1px solid #ddd;
		}
		th {
			background-color: #f2f2f2;
		}
		a {
			text-decoration: none;
			color: #007bff;
		}
		a:hover {
			text-decoration: underline;
		}
		div {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
			margin: 20px auto;
			padding: 20px;
			width: 95%;
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
	<h3>考级成绩</h3>
</div>
<div>
<table border="2" cellpadding="0" cellspacing="0">
	<tr>
		<th>学年学期</th>
		<th>学号</th>
		<th>学生姓名</th>
		<th>考级课程</th>
		<th>考级时间</th>
		<th>总成绩</th>
		<th>学生院系</th>
		<th>班级名称</th>
		<th>专业</th>
		<th>准考证号</th>
		<th>听力成绩</th>
		<th>阅读成绩</th>
		<th>写作成绩</th>
		<th>口语成绩</th>
	</tr>
	<%
		StudentBasicInformation student = (StudentBasicInformation)session.getAttribute("student");
		List<LevelExamination> levelExamination = (List<LevelExamination>)session.getAttribute("levelExamination");
	%>
	<%
		for(LevelExamination stu : levelExamination){
	%>
	<tr>
		<td><%= stu.getYearTerm()%></td>
		<td><%= stu.getStudentId()%></td>
		<td><%= student.getStudentName()%></td>
		<td><%= stu.getLevelEaxmCourse()%></td>
		<td><%= stu.getEaxmTime()%></td>
		<td><%= stu.getGrade() %></td>
		<td><%= student.getAcademy() %></td>
		<td><%= student.getClassName() %></td>
		<td><%= student.getProfession() %></td>
		<td><%= stu.getExamId() %></td>
		<td><%= stu.getListenGrade() %></td>
		<td><%= stu.getReadingGrade() %></td>
		<td><%= stu.getWritingGrade() %></td>
		<td><%= stu.getSpokenGrade() %></td>
	</tr>
	<%
		}
	%>
</table>
</div>
</body>
</html>
