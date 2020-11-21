package com.fashion.Service;

import java.util.List;

import com.fashion.Model.FashionItem;

public interface FashionService {

	List<FashionItem> getAdimnItems();

	FashionItem getItem(int id);

	void addItem(FashionItem fashionItem);

	void deleteItem(int id);

	List<FashionItem> getCustomerItems();
}
