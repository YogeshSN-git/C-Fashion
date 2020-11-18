package com.example.fashion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fashion.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Boolean existsByUserId(String userId);

	Boolean existsByUserIdAndPassword(String userId, String password);
}
