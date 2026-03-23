<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>

<h2>User Login</h2>

<form action="authenticate.jsp" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>

<%
    String error = request.getParameter("error");
    if(error != null){
%>
    <p style="color:red;">Invalid Username or Password</p>
<%
    }
%>

</body>
</html>
