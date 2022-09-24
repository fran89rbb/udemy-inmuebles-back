package com.springboot.microservicio.gateway.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.microservicio.gateway.service.UserServiceImpl;
import com.springboot.microservicio.gateway.utils.SecurityUtils;
import com.springboot.microservicio.gatewaymodels.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username)
				.orElseThrow( ()  -> new UsernameNotFoundException("El usuario " +username+ " no fue encontrado"));
		
		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.converttoAutority(user.getRole().name()));
		
		return UserPrincipal.builder()
				.user(user)
				.id(user.getId())
				.username(username)
				.password(user.getPassword())
				.authorities(authorities)
				.build();
	}

}
