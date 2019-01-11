package com.nosql.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nosql.mongo.document.User;
import com.nosql.mongo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userMongoRepository;

	@Before
	public void setUp() throws Exception {
		User user1 = new User("Alice");
		User user2 = new User("Bob");
		// save product, verify has ID value after save
		assertNull(user1.getId());
		assertNull(user2.getId());// null before save
		this.userMongoRepository.save(user1);
		this.userMongoRepository.save(user2);
		assertNotNull(user1.getId());
		assertNotNull(user2.getId());
	}

	@Test
	public void testFetchData() {
		/* Test data retrieval */
		User userA = userMongoRepository.findByName("Bob");
		assertNotNull(userA);
		/* Get all products, list should only have two */
		Iterable<User> users = userMongoRepository.findAll();
		int count = 0;
		for (User p : users) {
			count++;
		}
		assertEquals(count, 2);
	}

	@Test
	public void testDataUpdate() {
		/* Test update */
		User userB = userMongoRepository.findByName("Bob");
		userMongoRepository.save(userB);
		User userC = userMongoRepository.findByName("Bob");
		assertNotNull(userC);
	}

	@After
	public void tearDown() throws Exception {
		this.userMongoRepository.deleteAll();
	}

}