package com.springboot.microservicio.inmueble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservicio.inmueble.models.entity.InmuebleEntity;
import com.springboot.microservicio.inmueble.service.IInmuebleService;

@RestController
@RequestMapping("api/inmueble")
public class InmuebleController {
	
	@Autowired
	private IInmuebleService inmuebleService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(inmuebleService.findAll()); 
	}
	
	@PostMapping()
	public ResponseEntity<?> saveInmueble(@RequestBody InmuebleEntity inmuebleEntity) {
		return new ResponseEntity<>(inmuebleService.saveInmueble(inmuebleEntity), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteInmueble(@PathVariable Long id) {
		inmuebleService.deleteInmueble(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
