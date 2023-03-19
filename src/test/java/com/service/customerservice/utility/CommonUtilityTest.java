package com.service.customerservice.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommonUtilityTest {

    @Test
    void should_return_random_char_of_15_length(){
        String randomString = CommonUtility.generateUserId();
        System.out.println("Random String: " + randomString);
        Assertions.assertEquals(10, randomString.length());
    }

}