package com.example.jobs.app.model.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "userAccount",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Authority> authorities = new HashSet<>();

    @OneToOne
    private Person person;


}
