package com.springboot.microservicio.inmueble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservicio.inmueble.models.entity.InmuebleEntity;

public interface IInmuebleRepository extends JpaRepository<InmuebleEntity, Long>{

}
