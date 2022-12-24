package com.Registration.userService.impl;

import org.springframework.stereotype.Service;

import com.Registration.Model.request.UserDetailsRequestModel;
import com.Registration.Model.response.UserDetail;
import com.Registration.userService.UserService;

@Service
public class UserSeviceImpl implements UserService {

	@Override
	public UserDetail create(UserDetailsRequestModel userDetails) {
		
		UserDetail returnValue = new UserDetail();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		return returnValue;
	}

}
