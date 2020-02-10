package com.clarion.fundonote.service.serviceimp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clarion.fundonote.dto.LoginDTO;
import com.clarion.fundonote.dto.RegistrationDTO;
import com.clarion.fundonote.model.UserDetails;
import com.clarion.fundonote.repository.UserRepository;
import com.clarion.fundonote.service.UserService;
import com.clarion.fundonote.utils.JwtUtility;

@Service
@PropertySource("classpath:message.properties")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails registration(RegistrationDTO registrationDto) {
		//UserDetails userDetails = userRepository.findByEmail(registrationDto.getEmail());
		UserDetails userdetails = null;
		//if (userDetails == null) {
			userdetails = modelMapper.map(registrationDto, UserDetails.class);
			userdetails.setCreateTime(LocalDateTime.now());
			userdetails.setUpdateTime(LocalDateTime.now());
			userdetails.setPassword(bCryptPasswordEncoder.encode(userdetails.getPassword()));
			userdetails = userRepository.saveUser(userdetails);
		//}
		return userdetails;
	}

	@Override
	public List<UserDetails> getAllUsers(String token) {
		Long userId = JwtUtility.validateToken(token);
		UserDetails userDetails = userRepository.findUserById(userId);
		List<UserDetails> users = null;
		if (userDetails != null) {
			users = userRepository.getUserList();
		}
		return users;
	}

	@Override
	public String login(LoginDTO loginDto) {
		String token = null;
		UserDetails userDetails = userRepository.findByEmail(loginDto.getEmail());
		if (userDetails != null)
			if (bCryptPasswordEncoder.matches(loginDto.getPassword(), userDetails.getPassword())) {
				System.out.println("Userid for generate token : " + userDetails.getId());
				token = JwtUtility.generateToken(userDetails.getId());
			}
		return token;
	}

}
