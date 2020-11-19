package com.example.cart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cart.Model.FashionItem;

@Repository
public interface FashionRepository extends JpaRepository<FashionItem, Integer>{
	
}

