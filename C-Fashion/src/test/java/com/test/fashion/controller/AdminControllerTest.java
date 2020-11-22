package com.test.fashion.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fashion.Controller.AdminController;
import com.fashion.Model.FashionItem;
import com.fashion.Service.FashionService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

	FashionItem item1 = new FashionItem(1, "name", "category", 10.0, true);
	FashionItem item2 = new FashionItem(2, "name", "category", 10.0, false);

	@InjectMocks
	AdminController adminController;

	@Mock
	FashionService fashionService;

	@Test
	public void getAdimnItems() {

		List<FashionItem> findAll = new ArrayList<>();
		findAll.add(item1);
		findAll.add(item2);
		when(fashionService.getAdimnItems()).thenReturn(findAll);
		assertTrue(adminController.getAdimnItems("token").contains(item1) && adminController.getAdimnItems("token").contains(item2));
	}

	@Test
	public void addItem() {

		assertEquals(adminController.addItem("token",item1).getStatusCodeValue(), 200);
	}

	@Test
	public void delete() {

		assertEquals(adminController.deleteItem("token",item1.getId()).getStatusCodeValue(), 200);
	}

	
	
}
