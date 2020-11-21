package com.cart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByUserId(String userId);

}
