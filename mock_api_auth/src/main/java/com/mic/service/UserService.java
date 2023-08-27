package com.mic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.mic.dto.Product;
import com.mic.entity.UserInfo;
import com.mic.repository.UserInfoRepository;

@Service
public class UserService {

	@Autowired
	private UserInfoRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfo.setRoles("ROLE" + "_" + userInfo.getRoles());
		repository.save(userInfo);
		return "user added to system ";
	}
}
