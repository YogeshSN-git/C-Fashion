package com.example.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cart.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Boolean existsByUserId(String userId);
}
