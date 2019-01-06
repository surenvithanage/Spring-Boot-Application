package com.techguy.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techguy.application.model.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Integer>{

	User findByEmail(String email);
	User findByConfirmationToken(String confirmationToken);
	User findByUserName(String username);
	User findByEmailAndPassword(String email , String password);
	User findByPassword(String password);
	
}
