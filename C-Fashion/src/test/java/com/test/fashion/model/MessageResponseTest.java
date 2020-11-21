package com.test.fashion.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.fashion.Model.MessageResponse;

public class MessageResponseTest {

	MessageResponse messageResponse = new MessageResponse();

	MessageResponse message = new MessageResponse("responce");

	@Test
	public void testMessage() {
		messageResponse.setMessage("message");
		assertEquals(messageResponse.getMessage(), "message");
	}

	@Test
	public void testCons() {
		assertEquals(message.getMessage(), "responce");
	}
}
