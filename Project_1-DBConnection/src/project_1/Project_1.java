/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Project_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/result_system";
            String user = "root";
            String password = "";
            
            con = DriverManager.getConnection(url,user,password);
            
            System.out.println("Database Connected Successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println("Error: JDBC Driver not found");
        }
        catch(SQLException e){
            System.out.println("Error: Database connection failed");
            System.out.println("Reason: " + e.getMessage());
        }
        finally{
            try{
                if(con != null){
                    con.close();
                }
            }
            catch(SQLException e){
                System.out.println("Error while closing connection");
            }
        }
    }
    
}
