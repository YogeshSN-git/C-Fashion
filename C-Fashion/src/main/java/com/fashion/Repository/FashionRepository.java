package com.fashion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.Model.FashionItem;

@Repository
public interface FashionRepository extends JpaRepository<FashionItem, Integer>{
	
	List<FashionItem> findByInStockTrue();
}

