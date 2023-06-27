package com.demo.repository;

import com.demo.model.Account;
import com.demo.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account AS a WHERE a.name LIKE %:name%")
    List<Account> findAccountByName(String name);
}
