package com.example.cart.Model;

import java.beans.Transient;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

	@ManyToMany(mappedBy = "cartList")
	private Set<User> userList;

	@Column(length = 1000)
	private String image;

	
	@Transient
	public Set<User> getUserList() {
		return userList;
	}


}
