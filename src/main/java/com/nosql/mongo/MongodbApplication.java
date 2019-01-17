package com.nosql.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nosql.mongo.repository.UserRepository;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println(userRepo.count());
		System.err.println(userRepo.findAll());
	}

}
