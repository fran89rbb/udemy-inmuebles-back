package com.springboot.microservicio.inmueble.service;

import java.util.List;

import com.springboot.microservicio.inmueble.models.entity.InmuebleEntity;

public interface IInmuebleService {
	
	List<InmuebleEntity> findAll();
	
	InmuebleEntity saveInmueble(InmuebleEntity inmueble);
	
	void deleteInmueble(Long id);

}
