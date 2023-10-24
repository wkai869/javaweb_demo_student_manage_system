<%@page import="java.util.Map"%>
<%@page import="com.hua.entity.OptionalCourse"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学籍管理系统</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #007BFF;
			color: #4CAF50;
		}
		h1 {
			color: #333;
			text-align: center;
		}
		a {
			color: #007bff;
			text-decoration: none;
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
			width: 80%;
		}
		table {
			width: 100%;
			border-collapse: collapse;
		}
		th, td {
			padding: 10px;
			text-align: left;
			border-bottom: 1px solid #ddd;
		}
		th {
			background-color: #f2f2f2;
		}
		tr:hover {
			background-color: #f5f5f5;
		}
		.button {
			background-color: #007BFF; /* 背景色 */
			color: #fff; /* 文字颜色 */
			text-align: center; /* 文字居中 */
			padding: 10px 20px; /* 内边距 */
			border-radius: 5px; /* 圆角 */
			font-size: 16px; /* 字体大小 */
			transition: background-color 0.3s ease; /* 背景色过渡动画 */
		}

		.button:hover {
			background-color: #4CAF50; /* 鼠标悬停时的背景色 */
		}
	</style>
</head>
<body>
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp" class="button">修改密码</a>
		<br><br><br>
		<a href="<%=request.getContextPath()%>/logoutServlet" class="button">注销</a>
		<br><br><br>
		<a href="<%=request.getContextPath() %>/student/student.jsp" class="button">返回上一步</a>
		<br>
	</div>
	<div>
		<h3>选课报名</h3>
			<form action="<%=request.getContextPath()%>/queryOptionalCourse.optional"  method="post">
				<div>
					<font color="RED">${sessionScope.message }	</font>
					<%session.removeAttribute("message"); %>
				</div>
				<table>
					<tr>
						<td>学年学期:</td>
						<td>
							<select name="yearTerm" >
								<option value=""></option>
								<option value="2017秋季">2017秋季</option>
								<option value="2017春季">2017春季</option>
								<option value="2016秋季">2016秋季</option>
								<option value="2016春季">2016春季</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="查询" class="button"/>
						</td>
					</tr>
				</table>
			</form>
	</div>
	<br><br>
	${sessionScope.message }
	<%session.removeAttribute("message"); %>
	<c:if test="${sessionScope.map != null }">
		<div>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>学年学期</th>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>学分</th>
					<th>课程类型</th>
					<th>任课老师</th>
					<th>上课方式</th>
					<th>上课时间</th>
					<th>是否已报名</th>
					<th></th>
				</tr>
				<%
					Map<OptionalCourse, String> map = (Map<OptionalCourse, String>)session.getAttribute("map");
					for(Map.Entry<OptionalCourse, String> entry : map.entrySet()){
				%>

					<tr>
						<td><%= entry.getKey().getYearTerm() %></td>
						<td><%= entry.getKey().getCourseId() %></td>
						<td><%= entry.getKey().getCourseName() %></td>
						<td><%= entry.getKey().getCredit() %></td>
						<td><%= entry.getKey().getCourseType() %></td>
						<td><%= entry.getKey().getTeacher() %></td>
						<td><%= entry.getKey().getClassWay() %></td>
						<td><%= entry.getKey().getClassTime() %></td>
						<td><%= entry.getValue() %></td>
						<td>
							<a href="<%=request.getContextPath()%>/studentApply.optional?courseId=<%= entry.getKey().getCourseId()%>">报名</a>

						</td>
					</tr>

				<%
					}
				%>
			</table>
		</div>
	</c:if>
</body>
</html>