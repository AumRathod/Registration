package com.Registration.Model.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class UserDetailsRequestModel {
	@NotBlank
	private String firstName;
	
	@NotBlank(message = "last name cant be null")
	private String lastName;
	
	@Id
	@NotBlank
	@Email(message = "Plz enter valid email")
	private String email;
	
	@NotBlank
	@Size(min=5,max=16,message="Not appropriate password")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fristName) {
		this.firstName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
