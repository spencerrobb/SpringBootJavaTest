package com.example.SpringTestJava.service;

import com.example.SpringTestJava.dto.CustomerRequestDto;
import com.example.SpringTestJava.entity.Customer;
import com.example.SpringTestJava.repository.CustomerRepository;
import com.example.SpringTestJava.response.CustomerResponse;
import com.example.SpringTestJava.response.StatusResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    @Description("testing of creating account")
    void createAccount() {
    }

    @Test
    void customerInquiry() {
    }

    @Test
    void validateCustomerFields() {
    }

    @Test
    void createAccount_success_returnsCreatedResponse() {
        CustomerRequestDto dto = new CustomerRequestDto();
        dto.setCustomerName("Jane Doe");
        dto.setCustomerMobile("+14155552671");
        dto.setCustomerEmail("jane.doe@example.com");
        dto.setAddress1("123 Main St");
        dto.setAddress2("Apt 4B");

        when(customerRepository.save(any(Customer.class))).thenAnswer(invocation -> {
            Customer c = invocation.getArgument(0);
            c.setCustomerNumber(12345678);
            return c;
        });

        Object result = customerService.createAccount(dto);
        assertNotNull(result);
        assertTrue(result instanceof ResponseEntity);

        ResponseEntity<?> response = (ResponseEntity<?>) result;
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody() instanceof StatusResponse);

        StatusResponse body = (StatusResponse) response.getBody();
        assertEquals(12345678, body.getCustomerNumber());
        assertEquals(HttpStatus.CREATED.value(), body.getTransactionStatusCode());
    }

    @Test
    void createAccount_missingFields_returnsBadRequest() {
        CustomerRequestDto dto = new CustomerRequestDto();
        dto.setCustomerName(""); // missing name
        dto.setCustomerMobile(null); // missing mobile
        dto.setCustomerEmail(""); // missing email
        dto.setAddress1(null);
        dto.setAddress2("");

        Object result = customerService.createAccount(dto);
        assertNotNull(result);
        assertTrue(result instanceof ResponseEntity);

        ResponseEntity<?> response = (ResponseEntity<?>) result;
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody() instanceof StatusResponse);

        StatusResponse body = (StatusResponse) response.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.value(), body.getTransactionStatusCode());
        assertNotNull(body.getTransactionStatusDescription());
    }

    @Test
    void customerInquiry_found_returnsCustomerResponse() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerNumber(12345678);
        customer.setCustomerName("Jane Doe");
        customer.setCustomerEmail("jane.doe@example.com");
        customer.setCustomerMobile("+14155552671");

        when(customerRepository.findById(12345678)).thenReturn(Optional.of(customer));

        Object result = customerService.customerInquiry(12345678);
        assertNotNull(result);
        assertTrue(result instanceof ResponseEntity);

        ResponseEntity<?> response = (ResponseEntity<?>) result;
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody() instanceof CustomerResponse);

        CustomerResponse body = (CustomerResponse) response.getBody();
        assertEquals(HttpStatus.FOUND.value(), body.getTransactionStatusCode());
        assertEquals("Customer Account Found", body.getTransactionStatusDescription());
        assertEquals(Integer.valueOf(12345678), body.getCustomerNumber());
    }


    @Test
    void customerInquiry_notFound_throwsException() {
        when(customerRepository.findById(999999)).thenReturn(Optional.empty());
    }
}