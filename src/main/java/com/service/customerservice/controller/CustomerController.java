package com.service.customerservice.controller;

import com.service.customerservice.service.CustomerService;
import com.service.customerservice.viewmodel.request.CreateCustomerRequest;
import com.service.customerservice.viewmodel.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> createCustomer(@Validated  @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.create(createCustomerRequest);
    }
}
