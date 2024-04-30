package com.example.SpringTestJava.service;

import com.example.SpringTestJava.dto.CustomerRequestDto;
import com.example.SpringTestJava.error.CustomerNotFoundException;

public interface CustomerService {
    Object createAccount(CustomerRequestDto customerRequestDto);

    Object customerInquiry(Integer customerNumber) throws CustomerNotFoundException;
}
