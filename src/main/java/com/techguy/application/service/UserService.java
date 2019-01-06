package com.techguy.application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.techguy.application.model.User;

public interface UserService {
	
	User addUser(User user);

	ResponseEntity<String> deleteUser(int id);

	ResponseEntity<String> deleteAllUsers();

	List<User> getAllUsers();

	User getUser(int id);

	ResponseEntity<User> updateUser(int id, User user);
	
}
