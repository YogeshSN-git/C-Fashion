package com.authentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.model.Users;
import com.authentication.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUserId(username).orElse(null);
		if(user!=null) {
			return new User(user.getUserId(),user.getPassword(),new ArrayList<>());
		}
		return null;
	}

}
