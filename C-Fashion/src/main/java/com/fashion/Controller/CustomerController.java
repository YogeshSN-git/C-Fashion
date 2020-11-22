package com.fashion.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Feign.CartFeign;
import com.fashion.Model.FashionItem;
import com.fashion.Model.MessageResponse;
import com.fashion.Service.FashionService;
import com.fashion.Service.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	FashionService fashionService;

	@Autowired
	UserService userService;

	@Autowired
	CartFeign cartFeign;

	@GetMapping("/all")
	public List<FashionItem> getCustomerItems(@RequestHeader("Authorization") final String token) {
		return fashionService.getCustomerItems();
	}

	@PutMapping("/addtocart/{userId}/{itemId}")
	public ResponseEntity<?> addToCart(@RequestHeader("Authorization") final String token,@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		if (userService.isCustomer(userId)) {

			cartFeign.addToCart(userId, itemId);
			return ResponseEntity.ok().body(new MessageResponse("Added to Cart"));
		}

		return ResponseEntity.badRequest().body(new MessageResponse("Not a valid customer"));
	}

	@PutMapping("/removefromcart/{userId}/{itemId}")
	public ResponseEntity<?> removeFromCart(@RequestHeader("Authorization") final String token,@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {
		
		if (userService.isCustomer(userId)) {
			cartFeign.removeFromCart(userId, itemId);
			return ResponseEntity.ok().body(new MessageResponse("Removed From Cart"));
		}

		return ResponseEntity.badRequest().body(new MessageResponse("Not a valid customer"));
	}

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@RequestHeader("Authorization") final String token,@PathVariable(value = "userId") Integer userId) {
		return cartFeign.cart(userId);
	}

}
