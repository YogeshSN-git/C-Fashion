package com.example.fashion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashion.Model.FashionItem;
import com.example.fashion.Model.User;
import com.example.fashion.Service.FashionService;
import com.example.fashion.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FashionController {

	@Autowired
	UserService userService;

	@Autowired
	FashionService fashionService;

	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody User user) {

		if (userService.existByUserId(user.getUserId())) {
			log.error("User id already exist");
			return ResponseEntity.badRequest().body("User id already exist");
		}

		userService.addUser(user);
		return ResponseEntity.ok().body("User Registered Successfully");
	}

	@GetMapping("/item/{itemId}")
	public FashionItem getItem(@PathVariable(value = "itemId") Integer itemId) {
		return fashionService.getItem(itemId);
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
