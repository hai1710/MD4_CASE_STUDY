package com.demo.service.Company;

import com.demo.model.Company;
import com.demo.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService implements ICompanyService{
    @Autowired
    private ICompanyRepository companyRepository;
    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Iterable<Company> findByName(String name) {
        return companyRepository.findCompaniesByName(name);
    }

    @Override
    public Long count() {
        return companyRepository.count();
    }

    @Override
    public void remove(Long id) {
        companyRepository.deleteById(id);
    }
}
