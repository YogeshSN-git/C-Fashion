package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.authentication.model.Users;

@SpringBootTest
public class UsersTest {

	Users users = new Users();
	Users userConstructor=new Users("name", "userId", "password", "role");

	@Test
	public void testId() {
		users.setId(1);
		assertEquals(users.getId(), 1);
	}

	@Test
	public void testConstructor() {
		assertEquals(userConstructor.getName(),"name");
	}

	@Test
	public void testName() {
		users.setName("name");
		assertEquals(users.getName(), "name");
	}

	@Test
	public void testUserId() {
		users.setUserId("userId");
		assertEquals(users.getUserId(), "userId");
	}

	@Test
	public void testRole() {
		users.setRole("role");;
		assertEquals(users.getRole(), "role");
	}

	@Test
	public void testPassword() {
		users.setPassword("Password");
		assertEquals(users.getPassword(), "Password");
	}

	

}
