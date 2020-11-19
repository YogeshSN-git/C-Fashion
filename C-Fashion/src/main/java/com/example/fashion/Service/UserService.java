package com.example.fashion.Service;

import org.springframework.stereotype.Service;

import com.example.fashion.Model.User;

public interface UserService {

	void addUser(User user);

	User findUserById(int id);

	boolean existByUserId(String userId);

	boolean authenticateUser(String userId, String password);

}
