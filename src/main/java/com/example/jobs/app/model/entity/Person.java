package com.example.jobs.app.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<JobOffer> jobOffers = new ArrayList<>();

    @OneToOne
    private UserAccount userAccount;

}
