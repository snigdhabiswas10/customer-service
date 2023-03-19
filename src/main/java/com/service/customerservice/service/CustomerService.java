package com.service.customerservice.service;

import com.service.customerservice.domain.Customer;
import com.service.customerservice.repository.CustomerRepository;
import com.service.customerservice.viewmodel.common.ErrorDetails;
import com.service.customerservice.viewmodel.request.CreateCustomerRequest;
import com.service.customerservice.viewmodel.response.CommonResponse;
import com.service.customerservice.viewmodel.response.CustomerProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<CommonResponse> getCustomer(String userId) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserId(userId);
        return optionalCustomer
                .map(customer -> {
                    CustomerProfileResponse profileResponse = CustomerProfileResponse.from(customer);
                    return ResponseEntity.ok().body(CommonResponse.generateSuccessResponse(profileResponse));
                })
                .orElseGet(() -> {
                    ErrorDetails err = ErrorDetails.builder().errorCode("CUST-001").message("No Customer Info Found").build();
                    return ResponseEntity.badRequest().body(CommonResponse.generateFailureResponse(err));
                });

    }

    public ResponseEntity<CommonResponse> create(CreateCustomerRequest createCustomerRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(createCustomerRequest.getUserName());
        return optionalCustomer
                .map(customer -> {
                    ErrorDetails err = ErrorDetails.builder().errorCode("CUST-002").message("Customer Already Exists").build();
                    return ResponseEntity.badRequest().body(CommonResponse.generateFailureResponse(err));
                })
                .orElseGet(() -> {
                    Customer newCustomer = Customer.buildNewCustomerProfile(createCustomerRequest);
                    CustomerProfileResponse profileResponse = CustomerProfileResponse.from(customerRepository.save(newCustomer));
                    return ResponseEntity.ok().body(CommonResponse.generateSuccessResponse(profileResponse));

                });
    }

}
