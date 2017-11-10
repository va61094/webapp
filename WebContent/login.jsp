<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to ADF 2.0 Java</h2>
<br>
<s:form action="login.htm" method="post" modelAttribute="user1">
Id:<s:input path="id"/><br>
Password:<s:input path="password"/><br>
<input type="submit" name="Login">
</s:form>
</body>
</html>