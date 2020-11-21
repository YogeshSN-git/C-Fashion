package com.test.fashion.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fashion.Controller.FashionController;
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
	
	@Test
	public void addUser() {	
		when(userService.existByUserId("uid")).thenReturn(false);
		assertEquals(fashionController.addUser(user).getStatusCodeValue(),200);
	}
	

	@Test
	public void addUserExist() {	
		when(userService.existByUserId("uid")).thenReturn(true);
		assertEquals(fashionController.addUser(user).getStatusCodeValue(),400);
	}
	
}
