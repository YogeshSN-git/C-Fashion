package com.test.fashion.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.fashion.Model.AuthResponse;

public class AuthResponseTest {

	AuthResponse auth = new AuthResponse();

	AuthResponse authC = new AuthResponse("auth", false);

	@Test
	public void testName() {
		auth.setName("name");
		assertEquals(auth.getName(), "name");
	}

	@Test
	public void testValid() {
		auth.setValid(true);
		assertTrue(auth.isValid());
	}
	
	@Test
	public void testCons() {
		assertEquals(authC.getName(), "auth");
		assertFalse(authC.isValid());
	}
}
