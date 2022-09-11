package com.springboot.microservicio.gatewaymodels.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", unique = true, nullable = false, length = 100)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "fecha_creacion", nullable = false)
	private LocalDateTime fechaCreacion;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

}
