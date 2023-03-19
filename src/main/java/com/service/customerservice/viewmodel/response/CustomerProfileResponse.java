package com.service.customerservice.viewmodel.response;

import com.service.customerservice.domain.Customer;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerProfileResponse {

    private String fullName;
    private String userId;
    private String username;
    private String emailId;
    private String mobileNo;
    private String image;

    public static CustomerProfileResponse from(Customer customer){
        return CustomerProfileResponse
                .builder()
                .fullName(customer.getFullName())
                .mobileNo(customer.getMobileNo())
                .username(customer.getUserName())
                .emailId(customer.getEmailId())
                .userId(customer.getUserId())
                .image(customer.getImage())
                .build();
    }
}
