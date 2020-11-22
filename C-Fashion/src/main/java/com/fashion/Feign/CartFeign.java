package com.fashion.Feign;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.fashion.Model.FashionItem;

@FeignClient("${cart.feign.url}")
public interface CartFeign {

	@PutMapping("/addtocart/{userId}/{itemId}")
	public void addToCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId);

	@PutMapping("/removefromcart/{userId}/{itemId}")
	public void removeFromCart(@PathVariable(value = "userId") Integer userId,
			@PathVariable(value = "itemId") Integer itemId);

	@GetMapping("/cart/{userId}")
	public Set<FashionItem> cart(@PathVariable(value = "userId") Integer userId);

	
}
