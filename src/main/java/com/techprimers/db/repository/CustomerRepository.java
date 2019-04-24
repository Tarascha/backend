package com.techprimers.db.repository;

import com.techprimers.db.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByUserName(String UserName);
}
