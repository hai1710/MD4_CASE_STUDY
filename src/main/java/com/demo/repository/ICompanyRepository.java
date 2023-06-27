package com.demo.repository;

import com.demo.model.Company;
import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
    @Query("SELECT c FROM Company AS c WHERE c.name LIKE %:name%")
    List<Company> findCompaniesByName(String name);
}
