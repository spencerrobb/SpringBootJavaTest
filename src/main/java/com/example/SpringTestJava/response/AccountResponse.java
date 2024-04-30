package com.example.SpringTestJava.response;

import com.example.SpringTestJava.entity.Account;

public class AccountResponse {

    private Integer accountNumber;
    private String accountTypeEnum;
    private Integer availableBalance;


    public AccountResponse(Account account) {
        if(account!=null){
            this.accountNumber = account.getAccountNumber();
            this.accountTypeEnum = account.getAccountTypeEnum();
            this.availableBalance = account.getAvailableBalance();
        }
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
