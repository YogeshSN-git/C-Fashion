package com.example.cart.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cart.Feign.FashionFeign;
import com.example.cart.Model.FashionItem;
import com.example.cart.Model.User;
import com.example.cart.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FashionFeign fashionFeign;

	public Set<FashionItem> showCart(int userId) {
		return userRepository.findById(userId).get().getCartList();
	}
	
	public void addToCart(Integer userId, Integer itemId) {

		User user = userRepository.findById(userId).get();
		user.getCartList().add(fashionFeign.getItem(itemId));

		userRepository.save(user);

		log.info("Item " + itemId + " added to user " + userId + " cart");

	}

	public void removeFromCart(Integer userId, Integer itemId) {
		User user = userRepository.findById(userId).get();
		user.getCartList().remove(fashionFeign.getItem(itemId));
		userRepository.save(user);
		
		log.info("Item "+itemId+" removed from user "+userId+" cart");

	}

}
