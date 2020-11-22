package com.fashion.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fashion.Model.AuthResponse;
import com.fashion.Model.Users;

@FeignClient("${auth.feign.url}")
public interface AuthFeign {

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public AuthResponse getValidity(@RequestHeader("Authorization") final String token) ;
	
	@PostMapping("/getusername")
	public String getUsername(@RequestBody String token) ;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Users userlogincredentials);

}
