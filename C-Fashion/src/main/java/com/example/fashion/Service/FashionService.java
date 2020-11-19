package com.example.fashion.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fashion.Model.FashionItem;

public interface FashionService {

	List<FashionItem> getAdimnItems();

	FashionItem getItem(int id);

	void addItem(FashionItem fashionItem);

	void deleteItem(int id);

	List<FashionItem> getCustomerItems();
}
