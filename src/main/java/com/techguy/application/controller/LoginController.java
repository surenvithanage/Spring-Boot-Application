package com.techguy.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techguy.application.model.User;
import com.techguy.application.repository.UserRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public ResponseEntity<User> findByEmailAndPassword(@Valid @RequestBody User userDetails) {
		try {
			User user = userRepository.findByEmailAndPassword(userDetails.getEmail(), userDetails.getPassword());
			if(user.getEmail().equals(userDetails.getEmail()) && user.getPassword().equals(userDetails.getPassword()))
				return new ResponseEntity<>(user , HttpStatus.OK);
		}catch(NullPointerException ex) {
			System.out.println("============================================== \n"
					+ " ---------Invalid Username or Password ---------- \n"
					+ "==============================================");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
