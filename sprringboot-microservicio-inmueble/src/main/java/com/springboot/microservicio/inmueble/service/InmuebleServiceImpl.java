package com.springboot.microservicio.inmueble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservicio.inmueble.models.entity.InmuebleEntity;
import com.springboot.microservicio.inmueble.repository.IInmuebleRepository;

@Service
public class InmuebleServiceImpl implements IInmuebleService {

	@Autowired
	private IInmuebleRepository inmuebleRepository;

	@Override
	public List<InmuebleEntity> findAll() {
		return inmuebleRepository.findAll();
	}

	@Override
	public InmuebleEntity saveInmueble(InmuebleEntity inmueble) {
		inmueble.setFechaCreacion(LocalDateTime.now());
		return inmuebleRepository.save(inmueble);
	}

	@Override
	public void deleteInmueble(Long id) {
		inmuebleRepository.deleteById(id);
	}

}
