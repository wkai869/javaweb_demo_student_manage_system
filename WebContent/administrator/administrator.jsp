<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
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
			padding: 20px 0;
		}
		div {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
			margin: 20px auto;
			padding: 20px;
			width: 30%;
		}
		a {
			display: block;
			text-align: center;
			text-decoration: none;
			color: #333;
			font-size: 16px;
			margin-bottom: 10px;
			transition: background-color 0.3s ease;
		}
		a:hover {
			background-color: #eee;
		}
		h3 {
			color: #333;
			text-align: left;
			padding: 10px 0;
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
<!-- 管理员的主页面 -->
<h1>${sessionScope.user.name },您好！</h1>
<div>
	<%session.setAttribute("path", request.getRequestURI()); %>
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp" class="button">修改密码</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/logoutServlet" class="button">注销</a>
</div>
<br><br>
<div>
	<h3>用户管理</h3>
	<a href="<%=request.getContextPath()%>/query.do" class="button">查看用户</a>
</div>
<div>
	<br><br>
	<h3>系统维护</h3>
	<a href="<%=request.getContextPath()%>/administrator/systemmaintain/systemmaintain.jsp" class="button">查看日志</a>
</div>
</body>
</html>
