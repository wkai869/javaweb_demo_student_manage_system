<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>学籍信息</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #007BFF;
			color: #000000;
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
		form {
			width: 50%;
			margin: 0 auto;
			background-color: #fff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		input[type="text"], input[type="submit"] {
			width: 80%;
			padding: 10px;
			margin-bottom: 10px;
			border: 1px solid #ccc;
			border-radius: 3px;
		}
		input[type="submit"] {
			background-color: #007bff;
			color: #fff;
			border: none;
		}
		input[type="submit"]:hover {
			background-color: #0056b3;
		}
		div {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
			margin: 20px auto;
			padding: 20px;
			width: 60%;
		}
	</style>
</head>
<body>
<h1>${sessionScope.user.name },您好！</h1>
<div>
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
	<a href="<%=request.getContextPath()%>/login/login.jsp">注销</a>
</div>
<div>
	<h3 align="center">学籍信息</h3>
</div>
<div>
	<font color="RED">${requestScope.message }</font>
</div>
<br>
<div>
<form action="<%=request.getContextPath()%>/studentInformationServlet" method="post">
		学号：<input type="text" readonly="readonly"  name="studentId" value="${requestScope.studentBasicInformation.studentId }"/>
		<br>
		姓名：<input type="text" readonly="readonly"  name="studentName" value="${requestScope.studentBasicInformation.studentName }"/>
		<br>
		性别：<input type="text" readonly="readonly"  name="gender" value="${requestScope.studentBasicInformation.gender }"/>
		<br>
	<br><br>
		年级：<input type="text" readonly="readonly"  name="grade" value="${requestScope.studentBasicInformation.grade }"/>
		<br>
		班级：<input type="text" readonly="readonly"  name="className" value="${requestScope.studentBasicInformation.className }"/>
		<br>
		学院：<input type="text" readonly="readonly"  name="academy" value="${requestScope.studentBasicInformation.academy }"/>
		<br>
	<br><br>
		专业：<input type="text" readonly="readonly"  name="profession" value="${requestScope.studentBasicInformation.profession }"/>
		<br>
		所在校区：<input type="text" readonly="readonly"  name="campus" value="${requestScope.studentBasicInformation.campus }"/>
		<br>
		联系电话：<input type="text" name="phone" value="${requestScope.studentBasicInformation.phone }"/>
		<br>
	<br><br>
		家庭地址：<input type="text" size="40" name="homeAddress" value="${requestScope.studentBasicInformation.homeAddress }"/>
	<br><br>
		<input type="submit" name="submit" value="修改"/>
		<a href="<%=request.getContextPath() %>/student/informationinquiry/informationinquiry.jsp">返回上一步</a>
</form>
</div>
</body>
</html>