<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学籍管理系统</title>
</head>
<body>
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	</div>
	<div>
		<h3>学籍变动</h3>
	</div>
</body>
</html>