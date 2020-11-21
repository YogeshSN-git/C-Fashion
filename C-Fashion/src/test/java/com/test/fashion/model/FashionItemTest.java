package com.test.fashion.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.Test;

import com.fashion.Model.FashionItem;
import com.fashion.Model.Users;

public class FashionItemTest {
	FashionItem fashionItem = new FashionItem();

	@Test
	public void testName() {

		fashionItem.setName("item");
		assertEquals(fashionItem.getName(), "item");
	}

	@Test
	public void testId() {

		fashionItem.setId(1);
		assertEquals(fashionItem.getId(), 1);
	}

	@Test
	public void testPrice() {

		fashionItem.setPrice(10.0);
		assertEquals(fashionItem.getPrice(), 10.0);
	}

	@Test
	public void testInStock() {

		fashionItem.setInStock(true);

		assertTrue(fashionItem.isInStock());
	}

	@Test
	public void testConstructor() {

		assertNotNull(fashionItem);
	}

	@Test
	public void testCart() {

		Users users = new Users();
		users.setName("item");

		HashSet<Users> hashSet = new HashSet<Users>();
		hashSet.add(users);
		fashionItem.setUserList(hashSet);
		assertTrue(fashionItem.getUserList().contains(users));
	}

	@Test
	public void testCategory() {

		fashionItem.setCategory("category");
		assertEquals(fashionItem.getCategory(),"category");
	}
}
