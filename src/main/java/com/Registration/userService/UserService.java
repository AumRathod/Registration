package com.Registration.userService;

import com.Registration.Model.request.UserDetailsRequestModel;
import com.Registration.Model.response.UserDetail;

public interface UserService {

	UserDetail create(UserDetailsRequestModel userDetails);
}
