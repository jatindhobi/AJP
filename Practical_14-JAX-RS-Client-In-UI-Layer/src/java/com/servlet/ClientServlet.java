/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.client.MyClient; 
import java.io.IOException; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*; 
 
@WebServlet("/client") 
public class ClientServlet extends HttpServlet { 
 
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse 
response) 
            throws ServletException, IOException { 
 
        String result = MyClient.getData(); 
 
        request.setAttribute("data", result); 
 
        request.getRequestDispatcher("index.jsp").forward(request, response); 
    } 
} 
