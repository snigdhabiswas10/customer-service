package com.service.customerservice.repository;

import com.service.customerservice.domain.CustomerLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerLoginRepository extends MongoRepository<CustomerLogin, String> {
}
