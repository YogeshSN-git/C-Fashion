package com.fashion.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FashionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String category;
	private double price;
	private boolean inStock;

	@JsonIgnore
	@ManyToMany(mappedBy = "cartList")
	private Set<Users> userList;

	public FashionItem(int id, String name, String category, double price, boolean inStock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.inStock = inStock;
	}

	
	
	
}
