package com.springboot.microservicio.gateway.service;

import java.util.Optional;

import com.springboot.microservicio.gateway.models.entity.User;

public interface IUserService {
	
	User saveUser(User user);
	
	Optional<User> findByUsername(String username);
	
	void changerole(String username, String newRole);

}
