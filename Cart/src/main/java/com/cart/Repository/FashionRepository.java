package com.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Model.FashionItem;

@Repository
public interface FashionRepository extends JpaRepository<FashionItem, Integer>{
	
}

