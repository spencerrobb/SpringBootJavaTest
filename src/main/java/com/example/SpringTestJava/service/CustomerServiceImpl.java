package com.example.SpringTestJava.service;

import com.example.SpringTestJava.Enums.AccountTypeEnum;
import com.example.SpringTestJava.dto.CustomerRequestDto;
import com.example.SpringTestJava.entity.Account;
import com.example.SpringTestJava.entity.Customer;
import com.example.SpringTestJava.error.CustomerNotFoundException;
import com.example.SpringTestJava.repository.CustomerRepository;
import com.example.SpringTestJava.response.CustomerResponse;
import com.example.SpringTestJava.response.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Object createAccount(CustomerRequestDto customerRequestDto) {

        List<String> errorList = validateCustomerFields(customerRequestDto);

        if(errorList.isEmpty() && errorList.size()==0){
            Customer customer = new Customer();
            customer.setCustomerNumber(12345678);
            customer.setCustomerName(customerRequestDto.getCustomerName());
            customer.setCustomerMobile(customerRequestDto.getCustomerMobile());
            customer.setCustomerEmail(customerRequestDto.getCustomerEmail());
            customer.setAddress1(customerRequestDto.getAddress1());
            customer.setAddress2(customerRequestDto.getAddress2());

            customerRepository.save(customer);
            StatusResponse success = new StatusResponse();
            success.setCustomerNumber(12345678);
            success.setTransactionStatusCode(HttpStatus.CREATED.value());
            success.setTransactionStatusDescription("Customer Account Created");
            return ResponseEntity.status(HttpStatus.CREATED).body(success);
        } else if(!errorList.isEmpty() && errorList.size()!=0){
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setTransactionStatusDescription(errorList);
            statusResponse.setTransactionStatusCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(statusResponse);
        } else {
            return null;
        }
    }

    @Override
    public Object customerInquiry(Integer customerNumber) throws CustomerNotFoundException {
        Optional<Customer> custOptional= customerRepository.findById(customerNumber);
        if(!custOptional.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        }
        Customer customer = customerRepository.findById(customerNumber).get();

                CustomerResponse customerResponse = new CustomerResponse(customer);

                Account account = new Account(10001,AccountTypeEnum.C.getDscp(),500);
                List<Account> accountList = new ArrayList<>();
                accountList.add(account);
                customerResponse.setAccountList(accountList);
                StatusResponse statusResponse = new StatusResponse();
                statusResponse.setTransactionStatusCode(HttpStatus.FOUND.value());
                statusResponse.setTransactionStatusDescription("Customer Account Found");
                customerResponse.setStatusResponse(statusResponse);
                return ResponseEntity.status(HttpStatus.FOUND).body(customerResponse);

    }

    public List<String> validateCustomerFields(CustomerRequestDto customerRequestDto){

        List<String> errorList = new ArrayList<>();
        if(customerRequestDto.getCustomerName().isEmpty()){
            errorList.add("Customer Name is required field");
        }
        if(customerRequestDto.getCustomerMobile().isEmpty()){
            errorList.add("Mobile No is required field");
        }
        if(customerRequestDto.getCustomerEmail().isEmpty()){
            errorList.add("Email is required field");
        }
        if(customerRequestDto.getAddress1().isEmpty()){
            errorList.add("Address1 is required field");
        }
        if(customerRequestDto.getAddress2().isEmpty()){
            errorList.add("Address2 is required field");
        }

        return errorList;
    }
}
