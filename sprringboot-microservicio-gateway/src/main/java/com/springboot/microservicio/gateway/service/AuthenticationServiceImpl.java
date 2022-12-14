package com.springboot.microservicio.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.springboot.microservicio.gateway.models.entity.User;
import com.springboot.microservicio.gateway.security.IJwtProvider;
import com.springboot.microservicio.gateway.security.UserPrincipal;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IJwtProvider jwtProvider;
	
	@Override
	public User signInAndReturnJWT(User signInRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
		);
		
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		String jwt = jwtProvider.generateToken(userPrincipal);
		
		User sigInUser = userPrincipal.getUser();
		sigInUser.setToken(jwt);
		
		return sigInUser;
	}

}
