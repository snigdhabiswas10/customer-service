package com.service.customerservice.viewmodel.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDetails {
    private String message;
    private String errorCode;
}
