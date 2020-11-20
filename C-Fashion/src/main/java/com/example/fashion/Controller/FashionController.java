package com.example.fashion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashion.Feign.AuthFeign;
import com.example.fashion.Model.AuthResponse;
import com.example.fashion.Model.Users;
import com.example.fashion.Service.FashionService;
import com.example.fashion.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class FashionController {

	@Autowired
	UserService userService;

	@Autowired
	FashionService fashionService;

	@Autowired
	AuthFeign authFeign;

	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody Users user) {

		if (userService.existByUserId(user.getUserId())) {
			log.error("User id already exist");
			return ResponseEntity.badRequest().body("User id already exist");
		}

		userService.addUser(user);
		return ResponseEntity.ok().body("User Registered Successfully");
	}

	@PostMapping("/getusername")
	public String getUsername(@RequestBody String token) {
		return authFeign.getUsername(token);
	}

	@PostMapping("/validate")
	public AuthResponse validate(@RequestBody String token) {
		return authFeign.getValidity(token);
	}

//	@GetMapping("/item/{itemId}")
//	public FashionItem getItem(@PathVariable(value = "itemId") Integer itemId) {
//		return fashionService.getItem(itemId);
//	}
//
//	@GetMapping("/user/{userId}")
//	public Users getUser(@PathVariable(value = "userId") Integer userId) {
//		return userService.getUser(userId);
//	}

//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody User user){
//		if(userService.authenticateUser(user.getUserId(),encoder.encode(user.getPassword()))) {
//			log.info("Login Successful");
//			return ResponseEntity.ok().body("Login Successful");
//		}
//		log.warn("Login Failed, Incorrect credentials");
//		return ResponseEntity.badRequest().body("Login failed, Incorrect credentials");
//	}

}
