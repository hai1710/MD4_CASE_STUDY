    package com.demo.repository;

    import com.demo.model.Company;
    import com.demo.model.Job;
    import com.demo.model.Location;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.jdbc.core.JdbcOperations;
    import org.springframework.stereotype.Repository;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    @Repository
    public interface IJobRepository extends JpaRepository<Job, Long> {
        List<Job> findByTitleContainingOrCompany_NameContaining(String title, String companyName);

        Iterable<Job> findByTitleContainingIgnoreCase(String name);

        @Query("SELECT j FROM Job j JOIN j.company c WHERE (j.title LIKE %:search% OR c.name LIKE %:search%) AND j.jobType = :jobType AND j.jobLocation.id = :locationId")
        List<Job> searchJobs(@Param("search") String search, @Param("jobType") String jobType, @Param("locationId") Long locationId);

        @Query("SELECT j FROM Job j WHERE j.jobType = :jobType AND j.jobLocation.id = :locationId")
        List<Job> searchJobsByJobType(@Param("jobType") String jobType, @Param("locationId") Long locationId);

        @Query("SELECT j FROM Job j WHERE j.jobLocation.id = :locationId")
        List<Job> searchJobsByLocationId(@Param("locationId") Long locationId);
    }
