package com.clarion.fundonote.repository;

import java.util.List;

import com.clarion.fundonote.model.UserDetails;


public interface UserRepository {

	UserDetails findByEmail(String email);
	
	UserDetails saveUser(UserDetails user);
	
	UserDetails updateUser(UserDetails user);
	
	UserDetails deleteUser(UserDetails user);
	
	List<UserDetails> getUserList();
	
	UserDetails findUserById(Long userId);

	
}
