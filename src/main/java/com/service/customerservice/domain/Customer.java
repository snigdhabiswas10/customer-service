package com.service.customerservice.domain;

import com.service.customerservice.utility.CommonUtility;
import com.service.customerservice.viewmodel.request.CreateCustomerRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document("customer_profile")
public class Customer {

    @Id
    private String id;
    private String userId;
    private String fullName;
    private String userName;
    private String emailId;
    private String password;
    private String mobileNo;
    private String image;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public static Customer buildNewCustomerProfile(CreateCustomerRequest createCustomerRequest) {
        String userId = CommonUtility.generateUserId();
        return Customer.builder()
                .userId(userId)
                .fullName(createCustomerRequest.getFirstName())
                .emailId(createCustomerRequest.getEmailId())
                .mobileNo(createCustomerRequest.getMobileNo())
                .userName(createCustomerRequest.getUserName())
                .password(createCustomerRequest.getPassword())
                .build();
    }

}
