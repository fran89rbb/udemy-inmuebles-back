package com.springboot.microservicio.gateway.service;

import com.springboot.microservicio.gateway.models.entity.User;

public interface IAuthenticationService {

	User signInAndReturnJWT(User signInRequest);

}
