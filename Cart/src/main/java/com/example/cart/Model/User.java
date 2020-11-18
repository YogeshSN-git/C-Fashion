package com.example.cart.Model;

import java.beans.Transient;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String userId;
	private String password;

	@ManyToMany
	@JoinTable(name = "cart_list", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "fashionItem_id"))
	private Set<FashionItem> cartList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public Set<FashionItem> getCartList() {
		return cartList;
	}

	public void setCartList(Set<FashionItem> cartList) {
		this.cartList = cartList;
	}

}
