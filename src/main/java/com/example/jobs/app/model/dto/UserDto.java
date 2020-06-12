package com.example.jobs.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
