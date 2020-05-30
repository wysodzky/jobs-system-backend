package com.example.jobs.app.repository;

import com.example.jobs.app.model.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount,Long> {
    Optional<UserAccount> getByUsername(String username);
}
