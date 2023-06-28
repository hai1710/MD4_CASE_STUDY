package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Role;
import com.demo.service.Account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> showAccountFrom() {
        List<Account> accountList = (List<Account>) accountService.findAll();
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable("id") Long id) {
        Optional<Account> account = accountService.findById(id);
        if (!account.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account.get(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAccounts(){
        Long count = accountService.count();
        if (count != null){
            return new ResponseEntity<>(count,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Account>> searchAccountByName(@RequestParam("name") String name){
        Iterable<Account> accounts = accountService.findByName(name);
        if(accounts != null){
            return new ResponseEntity<>(accounts,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> addNewAccount(@RequestBody Account account) {
        Iterable<Account> accounts = accountService.findAll();
        Map<String, String> messageMap = new HashMap<>();
        for (Account account1: accounts){
        if (account.getEmail().equals(account1.getEmail())) {
            messageMap.put("message", "Email da ton tai");
            return new ResponseEntity<>(messageMap, HttpStatus.OK);
        }
            if (account.getPhone().equals(account1.getPhone())) {
                messageMap.put("message", "Phone da ton tai");
                return new ResponseEntity<>(messageMap, HttpStatus.OK);
            }
        }
        messageMap.put("message", "Đăng kí thành công");
        accountService.save(account);
        return new ResponseEntity<>(messageMap, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account){
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        account.setId(accountOptional.get().getId());
        return new ResponseEntity<>(accountService.save(account),HttpStatus.OK);
    }
}
