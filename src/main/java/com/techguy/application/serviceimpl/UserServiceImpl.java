package com.techguy.application.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techguy.application.model.User;
import com.techguy.application.repository.UserRepository;
import com.techguy.application.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseEntity<String> deleteUser(int id) {
		boolean status = true;
		try {
			userRepository.deleteById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			status = false;
		}
		if (status == true)
			return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
		else
			return new ResponseEntity<>("Exception thrown", HttpStatus.BAD_GATEWAY);
	}

	@Override
	public ResponseEntity<String> deleteAllUsers() {
		boolean status = true;
		try {
			userRepository.deleteAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			status = false;
		}
		if (status == true)
			return new ResponseEntity<>("Deleted all users successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Exception thrown", HttpStatus.NOT_FOUND);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userData = new ArrayList<>();
		try {
			userRepository.findAll().forEach(userData::add);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (userData.size() > 0) {
			return userData;
		} else {
			return null;
		}
	}

	@Override
	public User getUser(int id) {
		User user = new User();
		try {
			Optional<User> userData = userRepository.findById(id);
			if (userData.isPresent()) {
				user = userData.get();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public ResponseEntity<User> updateUser(int id, User user) {
		Optional<User> userData = userRepository.findById(id);
		if(userData.isPresent()) {
			User userInfo = userData.get();
			userInfo.setFirstname(user.getFirstname());
			userInfo.setLastName(user.getLastName());
			userInfo.setAge(user.getAge());
			userInfo.setCity(user.getCity());
			userInfo.setCountry(user.getCountry());
			userInfo.setAddressLineOne(user.getAddressLineOne());
			userInfo.setAddressLineTwo(user.getAddressLineTwo());
			userInfo.setEmail(user.getEmail());
			userInfo.setTelephone(user.getTelephone());
			userInfo.setProvince(user.getProvince());
			userInfo.setPassword(user.getPassword());
			userInfo.setProPicture(user.getProPicture());
			return new ResponseEntity<>(userRepository.save(userInfo),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
