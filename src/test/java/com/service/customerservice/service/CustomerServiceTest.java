package com.service.customerservice.service;

import com.service.customerservice.domain.Customer;
import com.service.customerservice.repository.CustomerRepository;
import com.service.customerservice.viewmodel.common.ErrorDetails;
import com.service.customerservice.viewmodel.request.CreateCustomerRequest;
import com.service.customerservice.viewmodel.response.CommonResponse;
import com.service.customerservice.viewmodel.response.CustomerProfileResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void should_return_customer_profile(){
        Customer customer = Customer.builder()
                .userId("JUTHFGTREWMNHUY")
                .emailId("Some@gmail")
                .fullName("name")
                .userName("username")
                .password("password")
                .build();
        when(customerRepository.findByUserId(any())).thenReturn(Optional.ofNullable(customer));

        ResponseEntity<CommonResponse> response = customerService.getCustomer("1");

        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getErrorDetails());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(CustomerProfileResponse.from(Objects.requireNonNull(customer)), response.getBody().getDetails());
    }

    @Test
    void should_return_bad_request_if_not_found(){
        when(customerRepository.findByUserId(any())).thenReturn(Optional.empty());

        ResponseEntity<CommonResponse> response = customerService.getCustomer("1");

        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getDetails());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        Assertions.assertEquals(ErrorDetails.builder().errorCode("CUST-001").message("No Customer Info Found").build(), response.getBody().getErrorDetails());
    }

    @Test
    void should_return_success_on_creating_customer_profile(){
        Customer customer = Customer.builder()
                .emailId("Some@gmail")
                .fullName("name")
                .userName("username")
                .password("password")
                .build();
        when(customerRepository.findByUserName(any())).thenReturn(Optional.empty());
        when(customerRepository.save(any())).thenReturn(customer);

        CreateCustomerRequest createCustomerRequest = CreateCustomerRequest.builder()
                .emailId("Some@gmail")
                .firstName("name")
                .middleName("middlename")
                .lastName("lastname")
                .userName("username")
                .password("password")
                .build();
        ResponseEntity<CommonResponse> response = customerService.create(createCustomerRequest);

        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getErrorDetails());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(CustomerProfileResponse.from(customer), response.getBody().getDetails());
    }

    @Test
    void should_return_error_if_customer_exists_while_creating_customer(){
        Customer customer = Customer.builder()
                .emailId("Some@gmail")
                .fullName("name")
                .userName("username")
                .password("password")
                .build();
        when(customerRepository.findByUserName(any())).thenReturn(Optional.ofNullable(customer));

        CreateCustomerRequest createCustomerRequest = CreateCustomerRequest.builder()
                .emailId("Some@gmail")
                .firstName("name")
                .middleName("middlename")
                .lastName("lastname")
                .userName("username")
                .password("password")
                .build();
        ResponseEntity<CommonResponse> response = customerService.create(createCustomerRequest);

        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getDetails());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        Assertions.assertEquals(ErrorDetails.builder().errorCode("CUST-002").message("Customer Already Exists").build(), response.getBody().getErrorDetails());

    }

}