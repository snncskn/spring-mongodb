package com.nosql.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nosql.mongo.document.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	User findByName(String name);
}
