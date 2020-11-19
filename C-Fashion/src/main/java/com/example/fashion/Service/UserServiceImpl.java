package com.example.fashion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fashion.Model.User;
import com.example.fashion.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FashionService fashionService;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public void addUser(User user) {

		User userObj = new User(user.getName(), user.getUserId(), encoder.encode(user.getPassword()),
				(user.getRole().equals("admin")) ? "ROLE_ADMIN" : "ROLE_USER");

		log.info("User Registered Successfully");
		userRepository.save(userObj);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public boolean existByUserId(String userId) {
		return userRepository.existsByUserId(userId);
	}

	@Override
	public boolean authenticateUser(String userId, String password) {
		return userRepository.existsByUserIdAndPassword(userId, password);
	}

	@Override
	public User getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}

}
