package com.example.jobs.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOfferDto implements Serializable {
    private String title;
    private String description;
    private List<String> requirements;
    private List<String> benefits;
    private String workType;
    private String workHours;
    private String salary;
    private String username;

}
