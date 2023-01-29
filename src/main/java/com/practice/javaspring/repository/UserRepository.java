package com.practice.javaspring.repository;

import com.practice.javaspring.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
