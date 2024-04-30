package com.example.SpringTestJava.repository;

import com.example.SpringTestJava.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByCustomerNumber(Integer customerNumber);

}
