package com.example.SpringTestJava.controller;

import com.example.SpringTestJava.dto.CustomerRequestDto;
import com.example.SpringTestJava.entity.Customer;
import com.example.SpringTestJava.error.CustomerNotFoundException;
import com.example.SpringTestJava.response.CustomerResponse;
import com.example.SpringTestJava.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/test")
    public String welcome(){
        return "hello world";
    }

    @PostMapping("/account")
    @ResponseStatus(code = HttpStatus.OK)
    public Object createAccount(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.createAccount(customerRequestDto);
    }

    @GetMapping("/account/{customerNumber}")
    public Object customerInquiry(@PathVariable(name = "customerNumber") Integer customerNumber) throws CustomerNotFoundException {
        return customerService.customerInquiry(customerNumber);
    }

}
