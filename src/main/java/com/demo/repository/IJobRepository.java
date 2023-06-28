package com.demo.repository;

import com.demo.model.Company;
import com.demo.model.Job;
import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepository extends JpaRepository<Job, Long> {

    List<Job> findByTitleContainingIgnoreCaseAndJobTypeIgnoreCase(String title, String jobType);
    List<Job> findByJobTypeIgnoreCase(String jobType);
    List<Job> findByTitleContainingIgnoreCaseOrCompany_NameContainingIgnoreCase(String title, String name);
    List<Job> findByJobLocation_NameContainingIgnoreCase(String name);

    Iterable<Job> findByTitleContainingIgnoreCase(String name);
}
