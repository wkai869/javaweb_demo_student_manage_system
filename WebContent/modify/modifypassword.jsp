<%@page import="java.util.Date"%>
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
		.findMM {
			width: 400px;
			margin: 50px auto;
			background-color: #fff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		.form-group {
			margin-bottom: 20px;
		}
		.form-group label {
			display: block;
			margin-bottom: 5px;
		}
		.form-group input {
			width: 80%;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 3px;
		}
		input[type="submit"] {
			background-color: #4CAF50;
			color: white;
			cursor: pointer;
		}
		input[type="submit"]:hover {
			background-color: #45a049;
		}
		a {
			display: inline-block;
			margin-top: 20px;
			text-decoration: none;
			color: #4CAF50;
		}
		a:hover {
			color: #45a049;
		}
	</style>
</head>
<body>
<!-- 修改密码页面 -->
<div class="findMM">
	<div>
		<% String tokenValue = new Date().getTime() +""; %>
		<c:set value="<%=tokenValue %>" var="token" scope="session"/>
	</div>
	<form action="<%=request.getContextPath()%>/modifyPasswordServlet" method="post">
		<div>
			${sessionScope.message }
			<%session.removeAttribute("message"); %>
		</div>
		<div>
			<input type="hidden" name="token" value="<%=tokenValue %>"/>
		</div>
		<div class="form-group">
			旧密码：<input type="password" name="oldpassword"/>
		</div>
		<br>
		<div class="form-group">
			新密码：<input type="password" name="newpassword"/>
		</div>
		<br>
		<div class="form-group">
			确认密码：<input type="password" name="confirmpassword"/>
		</div>
		<br>
		<div>
			<input type="submit" name="submit" value="确定" />
			<a href="${sessionScope.path }">返回</a>
		</div>
	</form>
</div>
</body>
</html>