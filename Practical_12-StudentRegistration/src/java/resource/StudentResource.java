package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnection;

@Path("/students")
public class StudentResource {

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerStudent(
            @FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("course") String course) {

        if (name == null || email == null || course == null ||
            name.isEmpty() || email.isEmpty() || course.isEmpty()) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("All fields required")
                    .build();
        }

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student(name, email, course) VALUES (?, ?, ?)")
        ) {

            if (con == null) {
                return Response.status(500)
                        .entity("DB connection failed")
                        .build();
            }

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int result = ps.executeUpdate();

            if (result > 0) {
                return Response.ok("Student Registered Successfully").build();
            } else {
                return Response.status(400).entity("Registration Failed").build();
            }

        } catch (SQLException e) {
            return Response.status(500)
                    .entity("DB Error: " + e.getMessage())
                    .build();
        }
    }
}
