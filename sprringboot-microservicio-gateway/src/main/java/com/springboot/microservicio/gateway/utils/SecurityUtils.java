package com.springboot.microservicio.gateway.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUtils {
	
	public static final String ROLE_PREFIX = "ROLE_";
	
	public static SimpleGrantedAuthority converttoAutority(String role) {
		String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
		
		return new SimpleGrantedAuthority(formattedRole);
	}

}
