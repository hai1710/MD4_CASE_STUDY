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
    private String job_type;
    @ManyToOne
    @JoinColumn(name = "location_id",referencedColumnName = "id")
    private Location job_Location;
    private String experience;
    private String employment_status;
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

    public Job(String title, String salary, String image, String job_type, Location job_Location, String experience, String employment_status, Date published_on, Date application_deadline, String description, String vacancy, String gender, String job_region, Boolean status, Company company) {
        this.title = title;
        this.salary = salary;
        this.image = image;
        this.job_type = job_type;
        this.job_Location = job_Location;
        this.experience = experience;
        this.employment_status = employment_status;
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

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public Location getJob_Location() {
        return job_Location;
    }

    public void setJob_Location(Location job_Location) {
        this.job_Location = job_Location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEmployment_status() {
        return employment_status;
    }

    public void setEmployment_status(String employment_status) {
        this.employment_status = employment_status;
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
