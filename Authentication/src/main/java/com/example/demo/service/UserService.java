package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUserId(username).orElse(null);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		System.out.println(user.getName()+user.getRole()+user.getUserId());

		return new User(user.getUserId(),user.getPassword(),new ArrayList<>());
	}

}
