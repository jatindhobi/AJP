//package com.example;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/convert")
public class currencyConvert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");
        double amount = Double.parseDouble(request.getParameter("amount"));

        double result = convert(from, to, amount);

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Converted Amount: " + result);
    }

    private double convert(String from, String to, double amount) {
        double usd = 83, inr = 1, eur = 90;

        double fromRate = from.equalsIgnoreCase("USD") ? usd :
                          from.equalsIgnoreCase("EUR") ? eur : inr;

        double toRate = to.equalsIgnoreCase("USD") ? usd :
                        to.equalsIgnoreCase("EUR") ? eur : inr;

        return (amount / fromRate) * toRate;
    }
}


// To run type this in browser url : Practical11/convert?from=USD&to=INR&amount=10