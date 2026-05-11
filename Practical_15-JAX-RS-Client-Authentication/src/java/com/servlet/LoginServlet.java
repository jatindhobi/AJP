package com.servlet;

import com.client.AuthClient;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Servlet Received: " + username);
        String result = AuthClient.authenticate(username, password);

        if ("SUCCESS".equals(result)) {
            request.setAttribute("message", "Login Successful!");
        } else {
            request.setAttribute("message", "Invalid Credentials!");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
