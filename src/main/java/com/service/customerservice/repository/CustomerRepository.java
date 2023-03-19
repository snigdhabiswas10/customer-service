package com.service.customerservice.repository;

import com.service.customerservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByUserName(String userName);
    Optional<Customer> findByUserId(String userId);
}
