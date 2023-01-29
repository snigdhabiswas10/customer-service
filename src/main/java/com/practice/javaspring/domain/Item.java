package com.practice.javaspring.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Builder
@Data
@Document("items")
public class Item {

    @Id
    private String id;
    private String name;
    @Field("available_quantity")
    private String availableQuantity;
    private BigDecimal price;
}
