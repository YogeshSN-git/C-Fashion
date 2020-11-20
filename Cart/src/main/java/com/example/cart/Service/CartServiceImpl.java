package com.example.cart.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cart.Model.FashionItem;
import com.example.cart.Model.Users;
import com.example.cart.Repository.FashionRepository;
import com.example.cart.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FashionRepository fashionRepository;

	public Set<FashionItem> showCart(int userId) {
		return userRepository.findById(userId).get().getCartList();
	}

	public void addToCart(Integer userId, Integer itemId) {

		Users user = userRepository.findById(userId).get();
		user.getCartList().add(fashionRepository.findById(itemId).get());

		userRepository.save(user);

		log.info("Item " + itemId + " added to user " + userId + " cart");

	}

	public void removeFromCart(Integer userId, Integer itemId) {
		Users user = userRepository.findById(userId).get();
		user.getCartList().remove(fashionRepository.findById(itemId).get());

		userRepository.save(user);

		log.info("Item " + itemId + " removed from user " + userId + " cart");

	}

}
