package com.fashion.Controller;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fashion.Model.MessageResponse;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataAccessExceptions(EmptyResultDataAccessException ex) {

		log.error("Item does not exist");
		return ResponseEntity.badRequest().body(new MessageResponse("Item does not exist"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(FeignException.BadRequest.class)
	public ResponseEntity<?> handleFeignBadRequestExceptions(FeignException ex) {

		log.error("Bad Request: Cannot find User or Fashion item");
		return ResponseEntity.badRequest().body(new MessageResponse("Bad Request: Cannot find User or Fashion item"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleNoSuchElementExceptionExceptions(NoSuchElementException ex) {

		log.error("Bad Request: Item does not exist");
		return ResponseEntity.badRequest().body(new MessageResponse("Bad Request: Item does not exist"));
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(FeignException.Unauthorized.class)
	public ResponseEntity<?> handleFeignUnauthorizedExceptions(FeignException ex) {

		log.error("Unauthorized request");
		return ResponseEntity.badRequest().body(new MessageResponse("Unauthorized request. Login again..."));
	}
	
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<?> handleUnauthorizedExceptions(UnauthorizedException ex) {

		log.error("Unauthorized request");
		return ResponseEntity.badRequest().body(new MessageResponse("Unauthorized request. Login again..."));
	}
	
	

}
