package com.example.fashion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashion.Model.User;
import com.example.fashion.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FashionService fashionService;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public User findUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void addToCart(Integer userId, Integer itemId) {
		User user = userRepository.findById(userId).get();
		user.getCartList().add(fashionService.getItem(itemId));
		
		userRepository.save(user);
	}

	public void removeFromCart(Integer userId, Integer itemId) {
		User user = userRepository.findById(userId).get();
		user.getCartList().remove(fashionService.getItem(itemId));
		userRepository.save(user);		
	}
	
	
	public boolean existByUserId(String userId) {
		return userRepository.existsByUserId(userId);
	}

	public boolean authenticateUser(User user) {
		return userRepository.existsByUserIdAndPassword(user.getUserId(),user.getPassword());
	}
	
	
	
}
