package com.example.jobs.app.repository;

import com.example.jobs.app.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query(value = "SELECT person_id FROM person_job_offers WHERE job_offers_id=?1", nativeQuery = true)
    Long getPersonIdByJobOfferId(Long id);
}
