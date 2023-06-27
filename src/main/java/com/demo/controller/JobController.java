package com.demo.controller;


import com.demo.model.Job;

import com.demo.service.job.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("job")
public class JobController {
    @Autowired
    private IJobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> showJobList() {
        List<Job> jobList = (List<Job>) jobService.findAll();
        if (jobList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jobList, HttpStatus.OK);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countJobs(){
        Long count = jobService.count();
        if (count != null){
            return new ResponseEntity<>(count,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.findById(id);
        if (!job.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job.get(), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Job>> searchJobByTitle(@RequestParam("title") String title){
        Iterable<Job> jobs = jobService.findByName(title);
        if(jobs != null){
            return new ResponseEntity<>(jobs,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Job> addNewCompany(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.save(job), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateAddress(@PathVariable Long id, @RequestBody Job job){
        Optional<Job> jobOptional = jobService.findById(id);
        if (!jobOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        job.setId(jobOptional.get().getId());
        return new ResponseEntity<>(jobService.save(job),HttpStatus.OK);
    }
}
