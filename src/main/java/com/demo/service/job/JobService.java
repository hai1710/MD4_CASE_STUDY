package com.demo.service.job;

import com.demo.model.Company;
import com.demo.model.Job;
import com.demo.model.Location;
import com.demo.repository.ICompanyRepository;
import com.demo.repository.IJobRepository;
import com.demo.repository.ILocationRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.*;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService implements IJobService {
    @Autowired
    private IJobRepository jobRepository;
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Iterable<Job> findByName(String name) {
        return jobRepository.findByTitleContainingIgnoreCase(name);
    }

    @Override
    public Long count() {
        return jobRepository.count();
    }

    @Override
    public void remove(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> searchJobs(String search, String jobType, Long locationId) {
        if (search == null && jobType == null && locationId == null) {
            return jobRepository.findAll();
        } else if (search != null && jobType != null && locationId != null) {
            return jobRepository.searchJobs(search, jobType, locationId);
        } else if (jobType != null && locationId != null) {
            return jobRepository.searchJobsByJobType(jobType, locationId);
        } else if (locationId != null) {
            return jobRepository.searchJobsByLocationId(locationId);
        } else {
            return jobRepository.findAll();
        }
    }
}
