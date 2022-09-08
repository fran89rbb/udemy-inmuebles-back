package com.springboot.microservicio.compra.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservicio.compra.models.entity.CompraEntity;
import com.springboot.microservicio.compra.repository.ICompraRepository;

@Service
public class CompraServiceImpl implements ICompraService {
	
	@Autowired
	private ICompraRepository compraRepository;

	@Override
	public CompraEntity saveCompra(CompraEntity compra) {
		
		compra.setFechaCompra(LocalDateTime.now());
		
		return compraRepository.save(compra);
	}

	@Override
	public List<CompraEntity> findAllComprasOfUser(Long userId) {
		return compraRepository.findByUserId(userId);
	}

}
