package com.Registration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.Registration.Model.request.UserDetailsRequestModel;

@Component
public interface UserPassRepo extends CrudRepository<UserDetailsRequestModel, String>{

}
