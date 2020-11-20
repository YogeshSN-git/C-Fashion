package com.example.fashion.Feign;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.fashion.Model.FashionItem;

@FeignClient("zuul-gateway/cart-service")
public interface FashionFeign {

	@PostMapping("/addtocart/{userId}/{itemId}")
	public void addToCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId);

	@PostMapping("/removefromcart/{userId}/{itemId}")
	public void removeFromCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId);

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@PathVariable(value = "userId") Integer userId);

	
}
