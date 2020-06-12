package com.example.jobs.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_offer")
@Data
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    @ElementCollection
    private List<String> requirements = new ArrayList<>();
    @ElementCollection
    private List<String> benefits = new ArrayList<>();
    private String workType;
    private String workHours;
    private String salary;

    @ManyToOne
    private Person person;

}
