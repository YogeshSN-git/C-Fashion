package com.test.fashion.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.fashion.Controller.RestExceptionHandler;
import com.fashion.Controller.UnauthorizedException;

import feign.FeignException;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerTest {

	@InjectMocks
	RestExceptionHandler restExceptionHandler;

	@Autowired
	FeignException feignException;

	@Test
	public void EmptyResultDataAccessException() {
		assertEquals(restExceptionHandler.handleEmptyResultDataAccessExceptions(new EmptyResultDataAccessException(1))
				.getStatusCodeValue(), 400);
	}

	@Test
	public void FeignException() {
		assertEquals(restExceptionHandler.handleFeignBadRequestExceptions(feignException).getStatusCodeValue(), 400);
	}

	@Test
	public void NoSuchElementException() {
		assertEquals(restExceptionHandler.handleNoSuchElementExceptionExceptions(new NoSuchElementException())
				.getStatusCodeValue(), 400);
	}

	@Test
	public void handleFeignUnauthorizedExceptions() {
		assertEquals(restExceptionHandler.handleFeignUnauthorizedExceptions(feignException).getStatusCodeValue(), 400);
	}
	@Test
	public void handleUnauthorizedExceptions() {
		assertEquals(restExceptionHandler.handleUnauthorizedExceptions(new UnauthorizedException(null)).getStatusCodeValue(), 400);
	}
}
