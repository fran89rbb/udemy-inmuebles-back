package com.springboot.microservicio.compra.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Value("${service.security.secure-key-username}")
	private String username;
	
	@Value("${service.security.secure-key-password}")
	private String password;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		
		authenticationManagerBuilder.inMemoryAuthentication()
		.withUser(username)
		.password(passwordEncoder().encode(password))
		.authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
		
		return http.antMatcher("/**")
				.authorizeRequests()
				.anyRequest()
				.hasRole("ADMIN")
				.and()
				.csrf()
				.disable()
				.httpBasic()
				.and().build();
	}

}
