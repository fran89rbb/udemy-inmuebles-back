package com.springboot.microservicio.compra.service;

import java.util.List;

import com.springboot.microservicio.compra.models.entity.CompraEntity;

public interface ICompraService {
	
	CompraEntity saveCompra(CompraEntity compra);
	
	List<CompraEntity> findAllComprasOfUser(Long userId);

}
