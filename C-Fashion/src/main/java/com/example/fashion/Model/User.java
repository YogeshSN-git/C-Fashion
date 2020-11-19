package com.example.fashion.Model;

import java.beans.Transient;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String userId;
	private String password;
	private String role;

	@ManyToMany
	@JoinTable(name = "cart_list", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "fashionItem_id"))
	private Set<FashionItem> cartList;

	public User(String name, String userId, String password, String role) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	@Transient
	public Set<FashionItem> getCartList() {
		return cartList;
	}

}
