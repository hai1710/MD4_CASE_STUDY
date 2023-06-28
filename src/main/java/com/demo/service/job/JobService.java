package com.demo.service.job;

import com.demo.model.Company;
import com.demo.model.Job;
import com.demo.model.Location;
import com.demo.repository.ICompanyRepository;
import com.demo.repository.IJobRepository;
import com.demo.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IJobService{
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

    @Override
    public List<Job> searchJobsAndCompanies(String searchTerm, String type, String location) {
        List<Job> result = new ArrayList<>();

        // Search for jobs by title and job type
        List<Job> jobsByTitleAndType = jobRepository.findByTitleContainingIgnoreCaseAndJobTypeIgnoreCase(searchTerm, type);
        result.addAll(jobsByTitleAndType);

        // Search for jobs by job type
        List<Job> jobsByType = jobRepository.findByJobTypeIgnoreCase(type);
        for (Job job : jobsByType) {
            if (!result.contains(job)) {
                result.add(job);
            }
        }

        // Search for jobs by title or company name
        List<Job> jobsByTitleOrCompany = jobRepository.findByTitleContainingIgnoreCaseOrCompany_NameContainingIgnoreCase(searchTerm, searchTerm);
        for (Job job : jobsByTitleOrCompany) {
            if (!result.contains(job)) {
                result.add(job);
            }
        }

        // Search for jobs by location name
        List<Job> jobsByLocation = jobRepository.findByJobLocation_NameContainingIgnoreCase(location);
        for (Job job : jobsByLocation) {
            if (!result.contains(job)) {
                result.add(job);
            }
        }

        return result;
    }



}
