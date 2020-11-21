package com.authentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.model.Users;


public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUserId(String userId);

}
