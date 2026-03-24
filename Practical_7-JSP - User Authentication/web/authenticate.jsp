<%@ page import="java.sql.*" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    String dbURL = "jdbc:mysql://localhost:3306/test";
    String dbUser = "root";
    String dbPass = "";   // XAMPP default is empty

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, dbUser, dbPass);

        ps = con.prepareStatement(
            "SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, username);
        ps.setString(2, password);

        rs = ps.executeQuery();

        if(rs.next()) {
%>
            <h2 style="color:green">Login Successful!</h2>
            <h3>Welcome <%= username %></h3>
            <a href="login.jsp">Logout</a>
<%
        } else {
            response.sendRedirect("login.jsp?error=1");
        }

    } catch(Exception e) {
        out.println("Database Error: " + e.getMessage());
    } finally {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(con != null) con.close();
    }
%>