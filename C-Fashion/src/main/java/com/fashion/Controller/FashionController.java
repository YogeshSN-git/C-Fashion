package com.fashion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Feign.AuthFeign;
import com.fashion.Model.MessageResponse;
import com.fashion.Model.Users;
import com.fashion.Service.FashionService;
import com.fashion.Service.UserService;

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
			return ResponseEntity.badRequest().body(new MessageResponse("User id already exist"));
		}

		userService.addUser(user);
		return ResponseEntity.ok().body(new MessageResponse("User Registered Successfully"));
	}

	

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
