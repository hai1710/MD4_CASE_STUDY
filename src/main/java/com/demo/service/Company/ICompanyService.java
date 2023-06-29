package com.demo.service.Company;

import com.demo.model.Account;
import com.demo.model.Company;
import com.demo.service.IGeneralService;

import java.util.Optional;

public interface ICompanyService extends IGeneralService<Company> {
    Optional<Company> findByAccount(Account account);
}
