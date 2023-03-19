package com.service.customerservice.viewmodel.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateCustomerRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String mobileNo;
    private String emailId;
    private String userName;
}
