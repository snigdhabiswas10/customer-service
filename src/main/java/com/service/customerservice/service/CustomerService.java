package com.service.customerservice.service;

import com.service.customerservice.domain.Customer;
import com.service.customerservice.repository.CustomerRepository;
import com.service.customerservice.viewmodel.common.ErrorDetails;
import com.service.customerservice.viewmodel.response.CustomerProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public ResponseEntity<?> getCustomer(String id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return ResponseEntity.ok().body(CustomerProfileResponse.from(optionalCustomer.get()));
        }
        return ResponseEntity.badRequest().body(ErrorDetails.builder().build());
    }
}
