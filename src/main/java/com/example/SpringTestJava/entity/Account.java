package com.example.SpringTestJava.entity;

import com.example.SpringTestJava.Enums.AccountTypeEnum;

public class Account {

    private Integer accountNumber;
    private String accountTypeEnum;
    private Integer availableBalance;

    public Account() {
    }

    public Account(Integer accountNumber, String accountTypeEnum, Integer availableBalance) {
        this.accountNumber = accountNumber;
        this.accountTypeEnum = accountTypeEnum;
        this.availableBalance = availableBalance;
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
