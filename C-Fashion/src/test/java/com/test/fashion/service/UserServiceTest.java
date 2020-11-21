package com.test.fashion.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fashion.Model.Users;
import com.fashion.Repository.UserRepository;
import com.fashion.Service.UserService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;

	@Test
	public void testAddUser() {
		Users user = new Users(1, "name", "uid", "upass", "urole", null);
		Optional<Users> data = Optional.of(user);

		when(userService.findUserById(1)).thenReturn(data);

		assertEquals(user.getUserId(), userService.findUserById(1).get().getUserId());
	}

	@Test
	public void loadUserByUsernameTest() {

		Users user = new Users(1, "name", "uid", "upass", "urole", null);
		Optional<Users> data = Optional.of(user);
		when(userRepository.findByUserId("uid")).thenReturn(data);

		UserDetails loadUserByUsername = userService.loadUserByUsername("uid");
		assertEquals(data.get().getUserId(), loadUserByUsername.getUsername());
	}

	@Test(expected = UsernameNotFoundException.class)
	public void loadUserByUsernameExceptionTest() {
		when(userService.loadUserByUsername("aaa")).thenThrow();
	}

	@Test
	public void testCustomer() {

		boolean data = true;
		when(userRepository.existsByIdAndRole(1, "ROLE_CUSTOMER")).thenReturn(data);

		assertTrue(userService.isCustomer(1));
	}

	@Test
	public void testUser() {
		Users user = new Users(1, "name", "uid", "upass", "ROLE_CUSTOMER", null);
		Optional<Users> user1 = Optional.of(user);
		when(userRepository.findById(1)).thenReturn(user1);
		assertEquals(user.getUserId(), userService.getUser(1).getUserId());
	}

	@Test
	public void testExist() {

		boolean data = true;
		when(userRepository.existsByUserId("uid")).thenReturn(data);

		assertTrue(userService.existByUserId("uid"));
	}

	@Test
	public void adduser() {
		Users user = new Users("name", "uid", "upass", "ROLE_CUSTOMER");
		userService.addUser(user);
	}
}
