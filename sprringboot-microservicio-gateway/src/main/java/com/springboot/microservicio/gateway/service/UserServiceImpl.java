package com.springboot.microservicio.gateway.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.microservicio.gateway.models.entity.Role;
import com.springboot.microservicio.gateway.models.entity.User;
import com.springboot.microservicio.gateway.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void changerole(String username, String newRole) {
		userRepository.updateUserRole(username, newRole);
	}

	@Override
	public User saveUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setFechaCreacion(LocalDateTime.now());
		
		return userRepository.save(user);
	}
	
}
