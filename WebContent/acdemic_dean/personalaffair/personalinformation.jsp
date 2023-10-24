<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
			width: 90%;
			margin: 0 auto;
			background-color: #fff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		input[type="text"], input[type="submit"] {
			width: 100%;
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
	<%session.setAttribute("path", request.getRequestURI()); %>
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
	<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	<br><br>
	<a href="<%=request.getContextPath() %>/acdemic_dean/acdemic_dean.jsp">返回上一步</a>
</div>
<!-- 教务员个人信息页面 -->
<div>
	<h3>个人信息</h3>
</div>
<div>
	<font color="RED">${requestScope.message }</font>
</div>
<br>
<div>
<form action="<%=request.getContextPath()%>/jwTeacherInformationServlet" method="post">
		教师编号：<input type="text" readonly="readonly" name="teacherId" value="${requestScope.teacher.teacherId }"/>
		<br>
		姓名：<input type="text" readonly="readonly" name="teacherName" value="${requestScope.teacher.teacherName }"/>
		<br>
		性别：<input type="text" readonly="readonly" name="gender" value="${requestScope.teacher.gender }"/>
		<br>
	<br><br>
		政治面貌：<input type="text" name="politicstatus" value="${requestScope.teacher.politicstatus }"/>
	<br>
		民族：<input type="text" readonly="readonly" name="nation" value="${requestScope.teacher.nation }"/>
	<br>
		籍贯：<input type="text" readonly="readonly" name="nativeplace" value="${requestScope.teacher.nativeplace }"/>
	<br><br>
		学院：<input type="text" readonly="readonly" name="academy" value="${requestScope.teacher.academy }"/>
	<br>
		QQ：<input type="text" size="40" name="qq" value="${requestScope.teacher.qq }"/>
	<br>
		联系电话：<input type="text" name="phone" value="${requestScope.teacher.phone }"/>
	<br><br>
		邮箱：<input type="text" size="40" name="email" value="${requestScope.teacher.email }"/>
		<br>
		地址：<input type="text" size="40" name="address" value="${requestScope.teacher.address }"/>
	<br><br>
		<input type="submit" name="submit" value="修改并保存"/>
</form>
</div>
</body>
</html>

