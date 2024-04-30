package com.example.SpringTestJava.entity;

import com.example.SpringTestJava.Enums.AccountTypeEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer accountNumber;
    private String accountTypeEnum;
    private Integer availableBalance;
    private Integer customerNumber;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Account() {
    }

    public Account(Integer accountNumber, String accountTypeEnum, Integer availableBalance) {
        this.accountNumber = accountNumber;
        this.accountTypeEnum = accountTypeEnum;
        this.availableBalance = availableBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountTypeEnum() {
        return accountTypeEnum;
    }

    public void setAccountTypeEnum(String accountTypeEnum) {
        this.accountTypeEnum = accountTypeEnum;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }
}
