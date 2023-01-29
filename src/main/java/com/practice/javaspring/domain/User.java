package com.practice.javaspring.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document("users")
public class User {

    @Id
    private String id;
    private String name;
    private String username;
    private String password;

}
