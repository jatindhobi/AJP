/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api;

import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
 
@Path("/students") 
public class StudentResource { 
 
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public String getStudents() { 
        return "[{\"id\":1,\"name\":\"Jatin\"},{\"id\":2,\"name\":\"Mit\"}]"; 
    } 
} 
