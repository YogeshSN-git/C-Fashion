package com.cart.Service;

import java.util.Set;

import com.cart.Model.FashionItem;

public interface CartService {

	Set<FashionItem> showCart(int userId);

	void addToCart(Integer userId, Integer itemId);

	void removeFromCart(Integer userId, Integer itemId);

}
