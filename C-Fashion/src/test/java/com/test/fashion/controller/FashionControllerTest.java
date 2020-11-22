package com.test.fashion.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.http.ResponseEntity;

import com.fashion.Controller.FashionController;
import com.fashion.Feign.AuthFeign;
import com.fashion.Model.Users;
import com.fashion.Service.UserService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FashionControllerTest {

	Users user = new Users("name", "uid", "upass", "ROLE_CUSTOMER");

	@InjectMocks
	FashionController fashionController;

	@Mock
	UserService userService;

	@Mock
	AuthFeign authFeign;

	@Test
	public void addUser() {
		when(userService.existByUserId("uid")).thenReturn(false);
		assertEquals(fashionController.addUser(user).getStatusCodeValue(), 200);
	}

	@Test
	public void addUserExist() {
		when(userService.existByUserId("uid")).thenReturn(true);
		assertEquals(fashionController.addUser(user).getStatusCodeValue(), 400);
	}

	@Test
	public void nullException() {
		Users user = new Users("name", null, null, "ROLE_CUSTOMER");

		assertEquals(fashionController.addUser(user).getStatusCodeValue(), 400);

	}

	@Test
	public void login() {
		ResponseEntity response = ResponseEntity.ok().body("test");
		when(authFeign.login(user)).thenReturn(response);
		assertEquals(fashionController.login(user).getStatusCodeValue(), 200);
	}
	
	

}
