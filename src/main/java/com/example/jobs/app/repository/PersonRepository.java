package com.example.jobs.app.repository;

import com.example.jobs.app.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query(value = "SELECT * FROM Person WHERE user_account_id=?1", nativeQuery = true)
    Person getByUserAccount(Long id);
}
