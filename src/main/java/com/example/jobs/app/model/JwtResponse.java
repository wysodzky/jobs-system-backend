package com.example.jobs.app.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private final String jwttoken;
    private final String email;
    private final String role;

    public JwtResponse(String jwttoken, String email, String role) {
        this.jwttoken = jwttoken;
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getJwttoken() {
        return jwttoken;
    }
}
