<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Integer users = (Integer)application.getAttribute("users");

    if(users > 3){
        response.sendRedirect("error.jsp");
        return;
    }
%>

<html>
<head>
    <title>Home Page</title>
</head>
<body>

<h2>Welcome User!</h2>

<h3>Active Users: <%= users %></h3>

</body>
</html>