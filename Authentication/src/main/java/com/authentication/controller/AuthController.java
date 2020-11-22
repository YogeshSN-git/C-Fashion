package com.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.model.AuthResponse;
import com.authentication.model.MessageResponse;
import com.authentication.model.Users;
import com.authentication.service.JwtUtil;
import com.authentication.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Users userlogincredentials) {

		final UserDetails userdetails = userService.loadUserByUsername(userlogincredentials.getUserId());
		
		String generateToken = "";
		
		try {
			if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
				generateToken = jwtutil.generateToken(userdetails);
				return new ResponseEntity<>(new MessageResponse(generateToken), HttpStatus.OK);
			} else {
				throw new UnauthorizedException("Invalid credentials");
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new UnauthorizedException("Invalid credentials");
		}

	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public AuthResponse getValidity(@RequestHeader("Authorization") final String token) {
//		String token1 = token.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setName(jwtutil.extractUsername(token));
			res.setValid(true);
		} else {
			res.setValid(false);
			log.info("At Validity : ");
			log.error("Token Has Expired");
		}
		return res;
	}

	@PostMapping("/getusername")
	public String getUsername(@RequestBody String token) {
		return jwtutil.extractUsername(token);
	}

}
