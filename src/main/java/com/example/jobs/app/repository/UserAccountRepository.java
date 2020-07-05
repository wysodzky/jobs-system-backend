package com.example.jobs.app.repository;

import com.example.jobs.app.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    Optional<UserAccount> getByUsername(String username);

    @Query(value = "SELECT * FROM user WHERE person_id=?1", nativeQuery = true)
    UserAccount getUserAccountByPersonId(Long id);
}
