<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f0f0f0;
			margin: 0;
			padding: 0;
		}

		h1 {
			text-align: center;
			color: #333;
			padding: 20px;
		}

		a {
			display: block;
			width: 200px;
			height: 50px;
			margin: 20px auto;
			background-color: #4CAF50;
			color: white;
			text-align: center;
			line-height: 50px;
			text-decoration: none;
			border-radius: 5px;
		}

		a:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
<h1>对不起，不能重复提交</h1>
<a href="<%=request.getContextPath() %>/login/login.jsp">点击这里，返回登录页面...
	测试github push,pull
</a>
</body>
</html>