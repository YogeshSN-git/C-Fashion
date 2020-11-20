package com.example.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cart.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
