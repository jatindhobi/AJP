/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.client;

import javax.ws.rs.client.*; 
import javax.ws.rs.core.MediaType; 
public class MyClient { 
 
private static final String URL = "http://localhost:9091/Practical_14/webapi/students"; 
 
    public static String getData() { 
        Client client = ClientBuilder.newClient(); 
        String response = client 
                .target(URL) 
                .request(MediaType.APPLICATION_JSON) 
                .get(String.class); 
        client.close(); 
        return response; 
    } 
} 

