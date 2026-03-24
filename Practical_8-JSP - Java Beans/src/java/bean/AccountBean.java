/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bean;

import javax.servlet.annotation.WebServlet;
import java.io.Serializable;
/**
 *
 * @author jatin
 */
@WebServlet(name = "AccountBean", urlPatterns = {"/AccountBean"})
public class AccountBean implements Serializable {
    
    private int accountNo;
    private String name;
    private double balance;
    
    
    public AccountBean() {
        balance = 0.0;
    }
    
    public int getAccountNo() {
        return accountNo;
    }
    
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    // Business methods
    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
