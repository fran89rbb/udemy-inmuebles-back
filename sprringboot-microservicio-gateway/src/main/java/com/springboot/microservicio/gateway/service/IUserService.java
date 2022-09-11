package com.springboot.microservicio.gateway.service;

import java.util.Optional;

import com.springboot.microservicio.gatewaymodels.entity.User;

public interface IUserService {
	
	User saveUser(User user);
	
	Optional<User> findByUsername(String username);
	
	void changerole(String username, String newRole);

}
