package com.example.SpringTestJava.service;

import com.example.SpringTestJava.entity.Account;

public interface AccountService {

    Account getAccountByCustomerNumber(Integer customerNumber);
}
