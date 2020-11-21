package com.test.fashion.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fashion.Model.FashionItem;
import com.fashion.Repository.FashionRepository;
import com.fashion.Service.FashionServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FashionServiceTest {

	FashionItem item1 = new FashionItem(1, "name", "category", 10.0, true);
	FashionItem item2 = new FashionItem(2, "name", "category", 10.0, false);

	@InjectMocks
	FashionServiceImpl fashionService;

	@Mock
	FashionRepository fashionRepository;

	@Test
	public void getAdimnItems() {

		List<FashionItem> findAll = new ArrayList<>();
		findAll.add(item1);
		findAll.add(item2);
		when(fashionRepository.findAll()).thenReturn(findAll);
		assertTrue(fashionService.getAdimnItems().contains(item1) && fashionService.getAdimnItems().contains(item2));
	}
	
	@Test
	public void getItem() {

		Optional<FashionItem> item=Optional.of(item1);
		when(fashionRepository.findById(1)).thenReturn(item);
		assertEquals(fashionService.getItem(1).getName(),item1.getName());
	}
	
	@Test
	public void addItem() {
		fashionService.addItem(item1);
	}
	
	@Test
	public void deleteItem() {
		fashionService.deleteItem(1);;
	}
	
	@Test
	public void getUserItems() {

		List<FashionItem> findAll = new ArrayList<>();
		findAll.add(item1);
		when(fashionRepository.findByInStockTrue()).thenReturn(findAll);
		assertTrue(fashionService.getCustomerItems().contains(item1));
	}

}
