package com.clarion.fundonote.service;


import java.util.List;

import com.clarion.fundonote.dto.LoginDTO;
import com.clarion.fundonote.dto.RegistrationDTO;
import com.clarion.fundonote.model.UserDetails;

public interface UserService {
	UserDetails registration(RegistrationDTO registrationDto);

	String login(LoginDTO loginDto);

	List<UserDetails> getAllUsers(String token);
	
}
