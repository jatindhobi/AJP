package com.api;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class AuthResource {

@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String login(@FormParam("username") String username,
@FormParam("password") String password) {
System.out.println("API Called: " + username);
if ("admin".equals(username) && "1234".equals(password)) {
return "SUCCESS";
} else {
return "FAIL";
}
}
}