<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta charset="UTF-8">
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
<h1>${sessionScope.user.name },您好！</h1>
<div>
	<%session.setAttribute("path", request.getRequestURI()); %>
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp" class="button">修改密码</a>
	<a href="<%=request.getContextPath()%>/logoutServlet" class="button">注销</a>
</div>
<!-- 教务员主页面 -->
<div>
	<h3>学籍管理</h3>
	<a href="<%=request.getContextPath()%>/acdemic_dean/schoolroll/studentinformation.jsp" class="button">学生基本信息</a>
</div>
<div>
	<h3>考级管理</h3>
	<a href="<%=request.getContextPath()%>/acdemic_dean/levelexaminationmanage/applystudents.jsp" class="button">考级报名学生</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/dean.query" class="button">考级学生成绩</a>
</div>
<div>
	<h3>教务管理</h3>
	<a href="<%=request.getContextPath()%>/acdemic_dean/acdemic/grademanagement.jsp" class="button">成绩管理</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/acdemic_dean/acdemic/optionalcourse.jsp" class="button">选修报名学生</a>
</div>
<div>
	<h3>个人事务</h3>
	<a href="<%=request.getContextPath()%>/jwTeacherInformationServlet" class="button">个人信息</a>
</div>
</body>
</html>