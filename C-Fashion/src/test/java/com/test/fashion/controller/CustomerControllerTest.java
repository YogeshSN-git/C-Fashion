package com.test.fashion.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fashion.Controller.CustomerController;
import com.fashion.Feign.CartFeign;
import com.fashion.Model.FashionItem;
import com.fashion.Service.FashionService;
import com.fashion.Service.UserService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	FashionItem item1 = new FashionItem(1, "name", "category", 10.0, true);
	FashionItem item2 = new FashionItem(2, "name", "category", 10.0, false);

	@InjectMocks
	CustomerController customerController;

	@Mock
	FashionService fashionService;

	@Mock
	UserService userService;

	@Mock
	CartFeign cartFeign;

	@Test
	public void getUserItems() {

		List<FashionItem> findAll = new ArrayList<>();
		findAll.add(item1);
		when(fashionService.getCustomerItems()).thenReturn(findAll);
		assertTrue(customerController.getCustomerItems("token").contains(item1));
	}

	@Test
	public void getCart() {
		Set<FashionItem> findAll = new HashSet<>();
		findAll.add(item1);
		when(cartFeign.cart(1)).thenReturn(findAll);
		assertTrue(customerController.cart("token",1).contains(item1));
	}

	@Test
	public void addToCart() {
		when(userService.isCustomer(1)).thenReturn(true);
		assertEquals(customerController.addToCart("token",1, 1).getStatusCodeValue(), 200);
	}

	@Test
	public void addToCartfalse() {
		when(userService.isCustomer(1)).thenReturn(false);
		assertEquals(customerController.addToCart("token",1, 1).getStatusCodeValue(), 400);
	}

	@Test
	public void removefromcart() {
		when(userService.isCustomer(1)).thenReturn(true);
		assertEquals(customerController.removeFromCart("token",1, 1).getStatusCodeValue(), 200);
	}

	@Test
	public void removefromcartfalse() {
		when(userService.isCustomer(1)).thenReturn(false);
		assertEquals(customerController.removeFromCart("token",1, 1).getStatusCodeValue(), 400);
	}
}
