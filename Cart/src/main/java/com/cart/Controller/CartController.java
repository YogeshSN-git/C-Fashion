package com.cart.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.Model.FashionItem;
import com.cart.Service.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CartController {

	@Autowired
	CartService cartService;


	@PutMapping("/addtocart/{userId}/{itemId}")
	public void addToCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		cartService.addToCart(userId, itemId);
	}

	@PutMapping("/removefromcart/{userId}/{itemId}")
	public void removeFromCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		cartService.removeFromCart(userId, itemId);
	}

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@PathVariable(value = "userId") Integer userId) {

		return cartService.showCart(userId);
	}

	

}
