package com.example.cart.Service;

import java.util.Set;

import com.example.cart.Model.FashionItem;

public interface CartService {

	Set<FashionItem> showCart(int userId);

	void addToCart(Integer userId, Integer itemId);

	void removeFromCart(Integer userId, Integer itemId);

}
