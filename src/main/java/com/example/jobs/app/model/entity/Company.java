package com.example.jobs.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<JobOffer> jobOffers = new ArrayList<>();

    @OneToOne
    private UserAccount userAccount;
}
