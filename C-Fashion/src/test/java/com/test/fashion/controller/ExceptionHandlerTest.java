package com.test.fashion.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.fashion.Controller.RestExceptionHandler;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerTest {

	@InjectMocks
	RestExceptionHandler restExceptionHandler;

	@Test
	public void EmptyResultDataAccessException() {
		assertEquals(restExceptionHandler.handleEmptyResultDataAccessExceptions(new EmptyResultDataAccessException(1))
				.getStatusCodeValue(), 400);
	}

//	@Test
//	public void FeignException() {
//		assertEquals(restExceptionHandler.handleFeignBadRequestExceptions(new FeignServerException).getStatusCodeValue(), 400);
//	}

	@Test
	public void NoSuchElementException() {
		assertEquals(restExceptionHandler.handleNoSuchElementExceptionExceptions(new NoSuchElementException())
				.getStatusCodeValue(), 400);
	}



}
