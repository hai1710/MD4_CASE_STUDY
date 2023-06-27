package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Company;
import com.demo.service.Account.IAccountService;
import com.demo.service.Company.ICompanyService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> showCompanyFrom() {
        List<Company> companyList = (List<Company>) companyService.findAll();
        if (companyList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        if (!company.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(company.get(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Company>> searchCompanyByName(@RequestParam("name") String name){
        Iterable<Company> companies = companyService.findByName(name);
        if( companies != null){
            return new ResponseEntity<>(companies,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCompanies(){
        Long count = companyService.count();
        if (count != null){
            return new ResponseEntity<>(count,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Company> addNewCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.save(company), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company){
        Optional<Company> companyOptional = companyService.findById(id);
        if (!companyOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        company.setId(companyOptional.get().getId());
        return new ResponseEntity<>(companyService.save(company),HttpStatus.OK);
    }
}
