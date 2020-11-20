package com.example.cart.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("zuul-gateway")
public interface CartFeign {

//	@GetMapping("/fashion-service/item/{itemId}")
//	public FashionItem getItem(@PathVariable(value = "itemId") Integer itemId);
//	
//	@GetMapping("fashion-service/user/{userId}")
//	public User getUser(@PathVariable(value = "userId") Integer userId) ;

}
