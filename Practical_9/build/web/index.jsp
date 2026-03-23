<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="st" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Custom Tag Sorting</title>
</head>
<body>

<h2>Sort 10 Numbers (Custom JSP Tag)</h2>

<form method="post">
    Enter 10 numbers (comma separated): <br><br>
    <input type="text" name="nums" size="40" required>
    <br><br>
    <input type="submit" value="Sort">
</form>

<br>

<%
    String numbers = request.getParameter("nums");
    if(numbers != null){
%>

<st:sort numbers="<%=numbers%>" />

<%
    }
%>

</body>
</html>