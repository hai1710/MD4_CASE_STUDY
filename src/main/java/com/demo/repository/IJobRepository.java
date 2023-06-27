package com.demo.repository;

import com.demo.model.Job;
import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job AS j WHERE j.title LIKE %:title%")
    List<Job> findJobByTitle(String title);
}
