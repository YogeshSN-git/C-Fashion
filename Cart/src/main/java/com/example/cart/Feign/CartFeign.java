package com.example.cart.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cart.Model.FashionItem;
import com.example.cart.Model.User;

@FeignClient("zuul-gateway")
public interface CartFeign {

	@GetMapping("/fashion-service/item/{itemId}")
	public FashionItem getItem(@PathVariable(value = "itemId") Integer itemId);
	
	@GetMapping("fashion-service/user/{userId}")
	public User getUser(@PathVariable(value = "userId") Integer userId) ;

}
