package com.example.jobs.app.model.entity;

import com.example.jobs.app.model.AuthorityType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Data
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;


    @Override
    public String getAuthority() {
        return name.name();
    }
}
