/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author jatin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection getCon() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/practical3_db",
                "root",
                ""
            );

            System.out.println("Database Connected Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found");

        } catch (SQLException e) {
            System.out.println("Database Connection Failed");

        }

        return con;
    }
}
