package com.example.cart.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.cart.Model.AuthResponse;

@FeignClient("zuul-gateway/auth-service")
public interface AuthFeign {

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public AuthResponse getValidity(@RequestBody String token) ;
	
	@PostMapping("/getusername")
	public String getUsername(@RequestBody String token) ;
	

}
