package com.example.fashion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashion.Model.FashionItem;
import com.example.fashion.Repository.FashionRepository;

@Service
public class FashionService {

	@Autowired
	FashionRepository fashionRepository;
	
	@Autowired
	UserService userService;

	public List<FashionItem> getAdimnItems() {
		return fashionRepository.findAll();
	}
	
	public FashionItem getItem(int id) {
		return fashionRepository.findById(id).get();
	}

	public void addItem(FashionItem fashionItem) {
		fashionRepository.save(fashionItem);
	}

	public void deleteItem(int id) {
		fashionRepository.deleteById(id);
	}

	public List<FashionItem> getCustomerItems() {
		return fashionRepository.findByInStockTrue();
	}

	
}
