package com.demo.service.job;

import com.demo.model.Company;
import com.demo.model.Job;
import com.demo.repository.ICompanyRepository;
import com.demo.repository.IJobRepository;
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
    public List<Job> searchJobsAndCompanies(String searchTerm) {
        List<Job> result = new ArrayList<>();

        // Search for jobs
        List<Job> jobs = jobRepository.findByTitleContainingIgnoreCase(searchTerm);
        for (Job job : jobs) {
            result.add(job);
        }

        // Search for companies
        List<Company> companies = companyRepository.findByNameContainingIgnoreCase(searchTerm);
        for (Company company : companies) {
            List<Job> companyJobs = jobRepository.findByCompany(company);
            for (Job job : companyJobs) {
                result.add(job);
            }
        }

        return result;
    }
}
