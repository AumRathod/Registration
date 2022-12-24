package com.Registration.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.Model.request.UserDetailsRequestModel;
import com.Registration.Model.request.UserLoginRequest;
import com.Registration.Model.response.UserDetail;
import com.Registration.dao.UserPassRepo;
import com.Registration.userService.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class RegistrationController {

	@Autowired
	UserPassRepo repo;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDetail> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserDetailsRequestModel udrm = repo.findById(userDetails.getEmail()).orElse(null);
		if(udrm==null)
		{	
			
			repo.save(userDetails);
			UserDetail returnValue = userService.create(userDetails) ;
			return new ResponseEntity<UserDetail>(returnValue,HttpStatus.OK);
		}
		return new ResponseEntity<UserDetail>(HttpStatus.CONFLICT);
	}

	@PostMapping("/login")
	public ResponseEntity<UserDetail> getUser(@RequestBody UserLoginRequest userLogin) {
		UserDetailsRequestModel udrm = repo.findById(userLogin.getEmail()).orElse(null);
		if(udrm!=null && userLogin.getPassword().equals(udrm.getPassword())) {
			
			UserDetail returnValue = userService.create(udrm) ;
			return new ResponseEntity<UserDetail>(returnValue,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
