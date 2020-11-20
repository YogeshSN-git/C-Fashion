package com.example.fashion.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashion.Feign.FashionFeign;
import com.example.fashion.Model.FashionItem;
import com.example.fashion.Service.FashionService;
import com.example.fashion.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	FashionService fashionService;

	@Autowired
	UserService userService;

	@Autowired
	FashionFeign fashionFeign;

	@GetMapping("/all")
	public List<FashionItem> getCustomerItems(@RequestHeader("Authorization") final String token) {
		return fashionService.getCustomerItems();
	}

	@PostMapping("/addtocart/{userId}/{itemId}")
	public ResponseEntity<?> addToCart(@RequestHeader("Authorization") final String token,@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		fashionFeign.addToCart(userId, itemId);
		return ResponseEntity.ok().body("Added to Cart");
	}

	@PostMapping("/removefromcart/{userId}/{itemId}")
	public ResponseEntity<?> removeFromCart(@RequestHeader("Authorization") final String token,@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		fashionFeign.removeFromCart(userId, itemId);
		return ResponseEntity.ok().body("Removed From Cart");
	}

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@RequestHeader("Authorization") final String token, @PathVariable(value = "userId") Integer userId) {
		return fashionFeign.cart(userId);
	}
	
}
