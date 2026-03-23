/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author jatin
 */
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    JTextField txtName, txtEmail, txtPhone;
    JButton btnSave;

    public Register() {

        setTitle("Registration Form");
        setSize(350, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(30, 30, 100, 25);
        add(l1);

        txtName = new JTextField();
        txtName.setBounds(120, 30, 150, 25);
        add(txtName);

        JLabel l2 = new JLabel("Email:");
        l2.setBounds(30, 70, 100, 25);
        add(l2);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 70, 150, 25);
        add(txtEmail);

        JLabel l3 = new JLabel("Phone:");
        l3.setBounds(30, 110, 100, 25);
        add(l3);

        txtPhone = new JTextField();
        txtPhone.setBounds(120, 110, 150, 25);
        add(txtPhone);

        btnSave = new JButton("Save");
        btnSave.setBounds(120, 160, 80, 30);
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        setVisible(true);
    }

    void saveData() {

        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return;
        }
        
        if (!name.matches("[A-Za-z ]+")) {
            JOptionPane.showMessageDialog(this, 
                "Name should contain only alphabets");
            txtName.requestFocus();
            return;
        }


        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email address");
            return;
        }

        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone must contain 10 digits only");
            return;
        }
        Connection con = DB.getCon();

        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database Not Connected");
            return;
        }

        try {
            String sql = "INSERT INTO users(name,email,phone) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtName.getText());
            ps.setString(2, txtEmail.getText());
            ps.setString(3, txtPhone.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Saved Successfully");

            new ViewData();
            this.dispose();

        } catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, e.getMessage());
}

    }

    public static void main(String[] args) {
        new Register();
    }
}