package com.example.SpringTestJava.response;

import com.example.SpringTestJava.Enums.AccountTypeEnum;
import com.example.SpringTestJava.entity.Account;
import com.example.SpringTestJava.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponse {

    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<AccountResponse> accountList;
    private Integer transactionStatusCode;
    private Object transactionStatusDescription;

    public Integer getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(Integer transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public Object getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(Object transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public List<AccountResponse> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountResponse> accountList) {
        this.accountList = accountList;
    }

    public CustomerResponse(Customer customer) {
        if(customer!=null){
            this.customerName=customer.getCustomerName();
            this.customerMobile=customer.getCustomerMobile();
            this.customerEmail=customer.getCustomerEmail();
            this.address1=customer.getAddress1();
            this.address2=customer.getAddress2();
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

}
