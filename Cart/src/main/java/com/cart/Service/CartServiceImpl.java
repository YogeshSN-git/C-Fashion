package com.cart.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Model.FashionItem;
import com.cart.Model.Users;
import com.cart.Repository.FashionRepository;
import com.cart.Repository.UserRepository;

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
		FashionItem item = fashionRepository.findById(itemId).get();
		
		System.out.println(user+" user "+item+" item");
		user.getCartList().add(item);

		userRepository.save(user);


	}

	public void removeFromCart(Integer userId, Integer itemId) {
		Users user = userRepository.findById(userId).get();
		user.getCartList().remove(fashionRepository.findById(itemId).get());

		userRepository.save(user);


	}

}
