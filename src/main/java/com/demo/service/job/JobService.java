package com.demo.service.job;

import com.demo.model.Job;
import com.demo.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService implements IJobService{
    @Autowired
    private IJobRepository jobRepository;

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
        return jobRepository.findJobByTitle(name);
    }

    @Override
    public Long count() {
        return jobRepository.count();
    }

    @Override
    public void remove(Long id) {
        jobRepository.deleteById(id);
    }
}
