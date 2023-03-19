package com.service.customerservice.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtility {
    public static String generateUserId(){
      return RandomStringUtils.randomAlphabetic(10).toUpperCase();
    }
}
