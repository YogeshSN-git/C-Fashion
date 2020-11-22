package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.authentication.controller.AuthController;
import com.authentication.model.AuthResponse;
import com.authentication.model.Users;
import com.authentication.service.JwtUtil;
import com.authentication.service.UserService;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {
	Users user = new Users("admin", "admin", "admin", "admin");

	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	UserService userservice;

		
	@Test
	public void loginTest() {
		UserDetails loadUserByUsername= new User("admin", "admin", new ArrayList<>());
		when(userservice.loadUserByUsername("admin")).thenReturn(loadUserByUsername);
		UserDetails value = new User(user.getUserId(), user.getPassword(), new ArrayList<>());
		when(userservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user);
		assertEquals(login.getStatusCodeValue(), 200);
	}

	@Test
	public void loginTestFailed() {

		Users user = new Users("admin", "admin", "admin", "admin");
		UserDetails loadUserByUsername = userservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), "admin11", new ArrayList<>());
		when(userservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user);
		assertEquals(login.getStatusCodeValue(), 403);
	}

	@Test
	public void validateTestValidtoken() {

		// when(authController.verifyToken("token")).thenReturn(new
		// AuthResponse("admin", "admin", true))
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("admin");
		Users user1 = new Users("admin", "admin", "admin", "admin");
		Optional<Users> data = Optional.of(user1);
//		when(userService.findById("admin")).thenReturn(data);
		AuthResponse validity = authController.getValidity("bearer token");
		assertEquals(validity.toString().contains("true"), true);

	}

	@Test
	public void validateTestInValidtoken() {

		// when(authController.verifyToken("token")).thenReturn(new
		// AuthResponse("admin", "admin", true))
		when(jwtutil.validateToken("token")).thenReturn(false);
		AuthResponse validity = authController.getValidity("token");
		assertEquals(validity.toString().contains("false"), true);
	}

}
