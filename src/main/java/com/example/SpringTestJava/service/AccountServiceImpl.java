package com.example.SpringTestJava.service;

import com.example.SpringTestJava.entity.Account;
import com.example.SpringTestJava.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getAccountByCustomerNumber(Integer customerNumber) {
        return accountRepository.findByCustomerNumber(customerNumber);
    }

}
