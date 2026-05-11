package com.client;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class AuthClient {

    private static final String URL
            = "http://localhost:8080/Practical_15/webapi/auth";

    public static String authenticate(String username, String password) {
        System.out.println("Calling API: " + URL);
        Client client = ClientBuilder.newClient();
        Form form = new Form();
        form.param("username", username);
        form.param("password", password);

        String response = client.target(URL)
                .request(MediaType.TEXT_PLAIN)
                .post(Entity.entity(form,
                        MediaType.APPLICATION_FORM_URLENCODED),
                        String.class);

        client.close();
        return response;
    }
}
