package com.example.demo.service;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String secretkey = "${jwt.secret}";

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody().getSubject();
	}

	public String generateToken(UserDetails userDetails) {
		String compact = Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))// token for 15 min
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		return compact;
	}

	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody().getExpiration();
			return true;

		} catch (ExpiredJwtException e) {
			return false;
		}
	}
}