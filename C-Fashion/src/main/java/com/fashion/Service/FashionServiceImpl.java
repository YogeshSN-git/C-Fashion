package com.fashion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.Model.FashionItem;
import com.fashion.Repository.FashionRepository;

@Service
public class FashionServiceImpl implements FashionService {

	@Autowired
	FashionRepository fashionRepository;
	
	@Autowired
	UserService userService;

	@Override
	public List<FashionItem> getAdimnItems() {
		return fashionRepository.findAll();
	}

	@Override
	public FashionItem getItem(int id) {
		return fashionRepository.findById(id).get();
	}

	@Override
	public void addItem(FashionItem fashionItem) {
		fashionRepository.save(fashionItem);
	}

	@Override
	public void deleteItem(int id) {
		fashionRepository.deleteById(id);
	}

	@Override
	public List<FashionItem> getCustomerItems() {
		return fashionRepository.findByInStockTrue();
	}

	
}
