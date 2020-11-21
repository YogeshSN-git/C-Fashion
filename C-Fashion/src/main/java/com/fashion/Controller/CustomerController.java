package com.fashion.Controller;

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

import com.fashion.Feign.FashionFeign;
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
	FashionFeign fashionFeign;

	@GetMapping("/all")
	public List<FashionItem> getCustomerItems() {
		return fashionService.getCustomerItems();
	}

	@PostMapping("/addtocart/{userId}/{itemId}")
	public ResponseEntity<?> addToCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {

		if (userService.isCustomer(userId)) {

			fashionFeign.addToCart(userId, itemId);
			return ResponseEntity.ok().body(new MessageResponse("Added to Cart"));
		}

		return ResponseEntity.badRequest().body(new MessageResponse("Not a valid customer"));
	}

	@PostMapping("/removefromcart/{userId}/{itemId}")
	public ResponseEntity<?> removeFromCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId) {
		
		if (userService.isCustomer(userId)) {
			fashionFeign.removeFromCart(userId, itemId);
			return ResponseEntity.ok().body(new MessageResponse("Removed From Cart"));
		}

		return ResponseEntity.badRequest().body(new MessageResponse("Not a valid customer"));
	}

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@PathVariable(value = "userId") Integer userId) {
		return fashionFeign.cart(userId);
	}

}
