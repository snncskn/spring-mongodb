package com.nosql.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
	private UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
		userRepository.save(new User("Sinan"));
		assertTrue(true);
	}

	@Test
	public void testFetchData() {
		User user = userRepository.findByName("Sinan");
		assertNotNull(user);
		assertEquals(userRepository.count(), 1);
	}

	@After
	public void tearDown() throws Exception {
		this.userRepository.deleteAll();
	}

}