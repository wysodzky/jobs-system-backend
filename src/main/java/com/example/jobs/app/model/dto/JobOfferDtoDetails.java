package com.example.jobs.app.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOfferDtoDetails extends JobOfferDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
