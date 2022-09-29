package com.springboot.microservicio.gateway.service;

import com.springboot.microservicio.gatewaymodels.entity.User;

public interface IAuthenticationService {

	User signInAndReturnJWT(User signInRequest);

}
