<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>信息查询</title>
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
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp" class="button">修改密码</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/logoutServlet" class="button">注销</a>
	<br><br>
	<a href="<%=request.getContextPath() %>/student/student.jsp" class="button">返回上一步</a>
</div>
<div>
	<h3>信息查询</h3>
	<a href="<%=request.getContextPath()%>/studentInformationServlet" class="button">学籍信息</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/student/informationinquiry/courseschedule.jsp" class="button">课表查询</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/studentquery.query" class="button">考级成绩</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/studentQuery.grade" class="button">课程成绩</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/student/informationinquiry/examarrange.jsp" class="button">考试安排</a>
</div>
</body>
</html>