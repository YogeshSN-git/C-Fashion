package com.fashion.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fashion.Model.Users;
import com.fashion.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	public void addUser(Users user) {

		Users userObj = new Users(user.getName(), user.getUserId(), user.getPassword(), user.getRole());

		userRepository.save(userObj);
		log.info("User Registered Successfully");
	}

	public Optional<Users> findUserById(int id) {
		return userRepository.findById(id);
	}

	public boolean existByUserId(String userId) {
		return userRepository.existsByUserId(userId);
	}


	public Users getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	public boolean isCustomer(Integer userId) {
		return userRepository.existsByIdAndRole(userId,"ROLE_CUSTOMER");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users findByName = userRepository.findByUserId(username).orElse(null);
		if(findByName==null) {
			throw new UsernameNotFoundException("User not found");
		}
		GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(findByName.getRole());

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(simpleGrantedAuthority);
		return new User(findByName.getUserId(), findByName.getPassword(), authorities);
	}

}
