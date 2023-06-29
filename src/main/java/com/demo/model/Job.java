package com.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String salary;
    private String image;
    private String jobType;
    @ManyToOne
    @JoinColumn(name = "location_id",referencedColumnName = "id")
    private Location jobLocation;
    private String experience;
    private Date published_on;
    private Date application_deadline;
    private String description;
    private String vacancy;
    private String gender;
    private String job_region;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Job() {
    }

    public Job(String title, String salary, String image, String jobType, Location jobLocation, String experience, Date published_on, Date application_deadline, String description, String vacancy, String gender, String job_region, Boolean status, Company company) {
        this.title = title;
        this.salary = salary;
        this.image = image;
        this.jobType = jobType;
        this.jobLocation = jobLocation;
        this.experience = experience;

        this.published_on = published_on;
        this.application_deadline = application_deadline;
        this.description = description;
        this.vacancy = vacancy;
        this.gender = gender;
        this.job_region = job_region;
        this.status = status;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String job_type) {
        this.jobType = job_type;
    }

    public Location getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(Location job_Location) {
        this.jobLocation = job_Location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Date getPublished_on() {
        return published_on;
    }

    public void setPublished_on(Date published_on) {
        this.published_on = published_on;
    }

    public Date getApplication_deadline() {
        return application_deadline;
    }

    public void setApplication_deadline(Date application_deadline) {
        this.application_deadline = application_deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob_region() {
        return job_region;
    }

    public void setJob_region(String job_region) {
        this.job_region = job_region;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
