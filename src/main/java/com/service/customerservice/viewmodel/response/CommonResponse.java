package com.service.customerservice.viewmodel.response;

import com.service.customerservice.viewmodel.common.ErrorDetails;
import com.service.customerservice.viewmodel.common.Status;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommonResponse {
    private Status status;
    private Object details;
    private ErrorDetails errorDetails;

    public static CommonResponse generateSuccessResponse(Object responseDetails){
        return CommonResponse
                .builder()
                .status(Status.SUCCESS)
                .details(responseDetails)
                .build();
    }

    public static CommonResponse generateFailureResponse(ErrorDetails errorDetails){
        return CommonResponse
                .builder()
                .status(Status.FAILURE)
                .errorDetails(errorDetails)
                .build();
    }
}
