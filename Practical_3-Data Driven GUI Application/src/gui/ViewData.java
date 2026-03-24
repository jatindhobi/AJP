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
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewData extends JFrame {

    JTable table;

    public ViewData() {

        setTitle("User Data");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Phone");

        table.setModel(model);

        Connection con = DB.getCon();

        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database Not Connected");
            return;
        }

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Fetch Failed");
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}
