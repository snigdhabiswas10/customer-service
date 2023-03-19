package com.service.customerservice.domain;

import com.service.customerservice.viewmodel.request.CreateCustomerRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerTest {

    @Test
    void should_build_new_customer(){
        try (MockedStatic<RandomStringUtils> utils = Mockito.mockStatic(RandomStringUtils.class)) {
            utils.when(() -> RandomStringUtils.randomAlphabetic(Mockito.anyInt())).thenReturn("ZSWPXTGGLN");
            Customer newCustomer = Customer.buildNewCustomerProfile(CreateCustomerRequest.
                    builder()
                    .emailId("Some@gmail")
                    .firstName("name")
                    .lastName("lastname")
                    .middleName("middle")
                    .mobileNo("9876543211")
                    .userName("username")
                    .password("password")
                    .build());
            Customer expectedCustomer = Customer.builder()
                    .userId("ZSWPXTGGLN")
                    .emailId("Some@gmail")
                    .fullName("name")
                    .userName("username")
                    .password("password")
                    .mobileNo("9876543211")
                    .build();
            //assertEquals("asdf", example.generatePassword());
            assertEquals(expectedCustomer, newCustomer);

        }


    }

}