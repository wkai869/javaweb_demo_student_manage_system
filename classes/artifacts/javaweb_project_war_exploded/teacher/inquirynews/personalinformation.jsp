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
			background-color: #f0f0f0;
		}
		h1 {
			text-align: center;
			color: #333;
		}
		div {
			margin: 20px;
		}
		a {
			display: inline-block;
			padding: 10px 20px;
			background-color: #4CAF50;
			color: white;
			text-decoration: none;
			border-radius: 5px;
		}
		a:hover {
			background-color: #45a049;
		}
		input[type="text"] {
			width: 200px;
			padding: 5px;
			border: 1px solid #ccc;
			border-radius: 5px;
		}
		input[type="submit"] {
			background-color: #4CAF50;
			color: white;
			border: none;
			cursor: pointer;
		}
		input[type="submit"]:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
<!-- 教师个人信息页面 -->
<h1>${sessionScope.user.name },您好！</h1>
<div>
	<%session.setAttribute("path", request.getRequestURI()); %>
	<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
	<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	<br><br>
	<a href="<%=request.getContextPath() %>/teacher/teacher.jsp">返回上一步</a>
</div>
<div>
	<h3>个人信息</h3>
</div>
<div>
	<font color="RED">${requestScope.message }</font>
</div>
<br>
<form action="<%=request.getContextPath()%>/teacherInformationServlet" method="post">
	<div>
		教师编号：<input type="text" readonly="readonly" name="teacherId" value="${requestScope.teacher.teacherId }"/>
		姓名：<input type="text" readonly="readonly" name="teacherName" value="${requestScope.teacher.teacherName }"/>
		性别：<input type="text" readonly="readonly" name="gender" value="${requestScope.teacher.gender }"/>
	</div>
	<br><br>
	<div>
		政治面貌：<input type="text" name="politicstatus" value="${requestScope.teacher.politicstatus }"/>
		民族：<input type="text" readonly="readonly" name="nation" value="${requestScope.teacher.nation }"/>
		籍贯：<input type="text" readonly="readonly" name="nativeplace" value="${requestScope.teacher.nativeplace }"/>
	</div>
	<br><br>
	<div>
		学院：<input type="text" readonly="readonly" name="academy" value="${requestScope.teacher.academy }"/>
		专业：<input type="text" readonly="readonly" name="profession" value="${requestScope.teacher.profession }"/>
		联系电话：<input type="text" name="phone" value="${requestScope.teacher.phone }"/>
	</div>
	<br><br>
	<div>
		邮箱：<input type="text" size="40" name="email" value="${requestScope.teacher.email }"/>
		地址：<input type="text" size="40" name="address" value="${requestScope.teacher.address }"/>

	</div>
	<br><br>
	<div>
		<input type="submit" name="submit" value="修改并保存"/>
	</div>
</form>
</body>
</html>
