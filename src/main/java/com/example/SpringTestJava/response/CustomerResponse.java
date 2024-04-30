package com.example.SpringTestJava.response;

import com.example.SpringTestJava.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponse {

    private String customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<AccountResponse> savings;
    private Integer transactionStatusCode;
    private Object transactionStatusDescription;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

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

    public List<AccountResponse> getSavings() {
        return savings;
    }

    public void setSavings(List<AccountResponse> savings) {
        this.savings = savings;
    }

    public CustomerResponse(Customer customer) {
        if(customer!=null){
            this.customerName=customer.getCustomerName();
            this.customerMobile=customer.getCustomerMobile();
            this.customerEmail=customer.getCustomerEmail();
            this.address1=customer.getAddress1();
            this.address2=customer.getAddress2();
            this.customerNumber=String.valueOf(customer.getCustomerNumber());
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
