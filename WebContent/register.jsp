<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Please fill below form to register</h2><br>
<s:form action="register.htm" method="post" modelAttribute="user">
id:<s:input path="id"/><br>
password:<s:input path="password"/><br>
name:<s:input path="name"/><br>
address:<s:input path="address"/><br>
phone:<s:input path="phone"/><br>
<input type="submit" name="Register"><br>

</s:form>

</body>
</html>