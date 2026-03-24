<%-- 
    Document   : account
    Created on : 27 Feb 2026, 9:43:15 am
    Author     : jatin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="bean.AccountBean" %>
<jsp:useBean id="acc" class="bean.AccountBean" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <title>Bank Account</title>
    </head>
    <body style="display:flex;justify-content: center;align-content: center;">

        <div style="flex-direction: column;padding: 20px; border-radius: 25px; border: 1px black solid ;">
            
        <h2>Bank Account Operations</h2>

        <form method="post">
            Account No: <br><input style="padding: 10px; border-radius: 12px" type="number" name="ano" required><br><br>
            Name: <br><input style="padding: 10px; border-radius: 12px" type="text" name="name" required><br><br>
            Amount:<br><input style="padding: 10px; border-radius: 12px" type="number" step="0.01" name="amount" required><br><br>
            

            <input type="submit" name="action" value="Deposit">
            <input type="submit" name="action" value="Withdraw">
        </form>

        <%
            String action = request.getParameter("action");

            if (action != null) {
                int ano = Integer.parseInt(request.getParameter("ano"));
                String name = request.getParameter("name");
                double amount = Double.parseDouble(request.getParameter("amount"));

                acc.setAccountNo(ano);
                acc.setName(name);

                if (action.equals("Deposit")) {
                    acc.deposit(amount);
                } else if (action.equals("Withdraw")) {
                    boolean success = acc.withdraw(amount);
                    if (!success) {
                        out.println("<p style='color:red'>Insufficient Balance</p>");
                    }
                }
            }
        %>

        <h3>Account Information</h3>
        Account No: <%= acc.getAccountNo()%><br>
        Name: <%= acc.getName()%><br>
        Balance: <%= acc.getBalance()%><br>

        </div>
    </body>
</html>
