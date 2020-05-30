package com.example.jobs.app.model.entity;

import com.example.jobs.app.model.AuthorityType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityType role;

    @ManyToOne
    private UserAccount userAccount;

    @Override
    public String getAuthority() {
        return role.name();
    }
}
