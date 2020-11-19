package com.example.cart.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cart.Model.FashionItem;

@FeignClient("zuul-gateway")
public interface FashionFeign {

	@GetMapping("/item/{itemId}")
	public FashionItem getItem(@PathVariable(value = "itemId") Integer itemId);

}
