<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>找回密码</title>
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
<!-- 找回密码页面 -->
<div class="findMM">
	<div>
		<% String tokenValue = new Date().getTime() +""; %>
		<c:set value="<%=tokenValue %>" var="token" scope="session"/>
	</div>
	<form action="<%=request.getContextPath()%>/findPasswordServlet" method="post">
		<div>
			${sessionScope.message }
		</div>
		<div>
			<input type="hidden" name="token" value="<%=tokenValue %>"/>
		</div>
		<div class="form-group">
			账号：<input type="text" name="username" value="${sessionScope.username }"/>
			<%session.removeAttribute("message"); %>
		</div>
		<br>
		<div class="form-group">
			凭据：<input type="text" name="idCard"/>
		</div>
		<br>
		<div class="form-group">
			验证码：<input type="text" name="CHECK_CODE_PARAM_NAME"/>
			<img alt="" src="<%= request.getContextPath() %>/validateColorServlet">
		</div>
		<br>
		<div>
			凭据默认是身份证或护照
		</div>
		<div>
			<input type="submit" name="submit" value="找回密码" size="21"/>
			<a href="<%=request.getContextPath() %>/login/login.jsp">返回登录</a>
		</div>
	</form>
</div>
</body>
</html>