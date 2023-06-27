package com.demo.service.Account;

import com.demo.model.Account;
import com.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Iterable<Account> findAll() {
        Iterable<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Iterable<Account> findByName(String name) {
        return accountRepository.findAccountByName(name);
    }

    @Override
    public Long count() {
        return accountRepository.count();
    }

    @Override
    public void remove(Long id) {
        accountRepository.deleteById(id);
    }
}
