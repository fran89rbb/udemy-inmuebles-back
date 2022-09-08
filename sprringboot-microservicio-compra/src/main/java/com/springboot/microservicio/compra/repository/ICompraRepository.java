package com.springboot.microservicio.compra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservicio.compra.models.entity.CompraEntity;

public interface ICompraRepository extends JpaRepository<CompraEntity, Long>{
	
	List<CompraEntity> findByUserId(Long userId);

}
