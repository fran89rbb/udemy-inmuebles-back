package com.springboot.microservicio.gateway.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface IJwtProvider {

	String generateToken(UserPrincipal auth);

	Authentication getAuthentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

}
