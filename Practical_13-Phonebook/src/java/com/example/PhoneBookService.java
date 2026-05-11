package com.example; 
 
import javax.ws.rs.*; 
import java.sql.*; 
 
@Path("/phone") 
public class PhoneBookService { 
 
    private Connection con; 
 
    // Constructor (runs once) 
    public PhoneBookService() { 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/phonebook", 
                "root", ""); 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
 
    // CREATE 
    @GET 
    @Path("/add") 
    public String add(@QueryParam("name") String name) { 
        try { 
            PreparedStatement ps = con.prepareStatement( 
                "INSERT INTO contacts(name) VALUES(?)"); 
            ps.setString(1, name); 
            ps.executeUpdate(); 
            return "Added"; 
        } catch (Exception e) { 
            return e.toString(); 
        } 
    } 
 
    // READ 
    @GET 
    @Path("/view") 
    public String view() { 
        String r = ""; 
        try { 
            ResultSet rs = con.createStatement() 
                    .executeQuery("SELECT * FROM contacts"); 
 
            while (rs.next()) 
                r += rs.getInt(1) + " : " + rs.getString(2) + "\n"; 
 
        } catch (Exception e) { 
            r = e.toString(); 
        } 
        return r; 
    } 
 
    // UPDATE 
    @GET 
    @Path("/update") 
    public String update(@QueryParam("id") int id, 
                         @QueryParam("name") String name) { 
        try { 
            PreparedStatement ps = con.prepareStatement( 
                "UPDATE contacts SET name=? WHERE id=?"); 
            ps.setString(1, name); 
            ps.setInt(2, id); 
            ps.executeUpdate(); 
            return "Updated"; 
        } catch (Exception e) { 
            return e.toString(); 
        } 
    } 
 
    // DELETE 
    @GET 
    @Path("/delete") 
    public String delete(@QueryParam("id") int id) { 
        try { 
            PreparedStatement ps = con.prepareStatement( 
                "DELETE FROM contacts WHERE id=?"); 
            ps.setInt(1, id); 
            ps.executeUpdate(); 
            return "Deleted"; 
        } catch (Exception e) { 
            return e.toString(); 
        } 
    } 
} 