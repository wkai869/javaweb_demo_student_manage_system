<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #007BFF;
			color: #4CAF50;
		}
		h1 {
			color: #000000;
			text-align: center;
			padding: 20px 0;
		}
		a {
			color: #007BFF;
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
			width: 30%;
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
		input[type="submit"] {
			background-color: #007BFF;
			color: white;
			border: none;
			padding: 10px 20px;
			cursor: pointer;
		}
		input[type="submit"]:hover {
			background-color: #4CAF50;
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
<div class="container">
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp" class="button">修改密码</a>
	<a href="<%=request.getContextPath()%>/logoutServlet" class="button">注销</a>
	<br><br>
	<a href="<%=request.getContextPath() %>/student/student.jsp" class="button">返回上一步</a>
</div>
<div>
	<h2>业务办理</h2>
<form action="<%=request.getContextPath()%>/postponeExamapplyServlet"  method="post">
		<font color="RED">${sessionScope.message }	</font>
		<%session.removeAttribute("message"); %>

	<table>
		<tr>
			<td>学年学期：</td>
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
			<td>申请课程：</td>
			<td>
				<input type="text" name="courseName"/>
			</td>
		</tr>
		<tr>
			<td>申请原因：</td>
			<td>
				<input type="text" name="applyReason" size=“100”/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="提交申请"/>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>