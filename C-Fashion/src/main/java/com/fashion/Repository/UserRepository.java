package com.fashion.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Boolean existsByUserId(String userId);

	Boolean existsByUserIdAndPassword(String userId, String password);

	Optional<Users> findByUserId(String userId);

	boolean existsByIdAndRole(Integer userId, String string);
}
