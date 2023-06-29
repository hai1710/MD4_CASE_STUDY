package com.demo.service.job;

import com.demo.model.Job;
import com.demo.service.IGeneralService;

import java.util.List;

public interface IJobService extends IGeneralService<Job> {
    public List<Job> searchJobs(String search, String jobType, Long locationId);

}
