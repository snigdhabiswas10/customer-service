package com.practice.javaspring.repository;

import com.practice.javaspring.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
