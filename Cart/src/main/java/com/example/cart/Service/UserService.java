package com.example.cart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cart.Model.Users;
import com.example.cart.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println(username);
		Users findByName = userRepository.findByUserId(username).orElse(null);
		if(findByName==null) {
			throw new UsernameNotFoundException("User not found");
		}
//		System.out.println(findByName.getName()+findByName.getRole()+findByName.getUserId());
		GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(findByName.getRole());

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(simpleGrantedAuthority);
		return new User(findByName.getUserId(), findByName.getPassword(), authorities);
	}

}
