package com.demo.repository;

import com.demo.model.Account;
import com.demo.model.Company;
import com.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
    List<Company> findByNameContainingIgnoreCase(String name);
    Optional<Company> findByAccount(Account account);

}
