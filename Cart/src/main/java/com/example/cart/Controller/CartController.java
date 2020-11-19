package com.example.cart.Controller;

import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart.Model.FashionItem;
import com.example.cart.Service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/addtocart/{userId}/{itemId}")
	public void addToCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		cartService.addToCart(userId, itemId);
	}

	@PostMapping("/removefromcart/{userId}/{itemId}")
	public void removeFromCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		cartService.removeFromCart(userId, itemId);
	}

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@PathVariable(value = "userId") Integer userId) {

		return cartService.showCart(userId);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleValidationExceptions(NoSuchElementException ex) {

		log.error("NoSuchElementException: User or Fashion item not present");
		return ResponseEntity.notFound().build();
	}

}
