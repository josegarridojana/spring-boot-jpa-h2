package com.prueba.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.spring.jpa.h2.model.Prueba;
import com.prueba.spring.jpa.h2.repository.PruebaRepository;
import com.prueba.spring.jpa.h2.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api")
@Api(value = "API para buscar estudiantes desde un repositorio por diferentes parámetros de búsqueda",
description = "Esta API proporciona la capacidad de buscar estudiantes desde un repositorio", produces = "application/json")
public class PruebaController {

	@Autowired
	PruebaRepository pruebaRepository;

	@ApiOperation(value = "Listar todos", produces = "application/json")
	@GetMapping("/pruebas")
	public ResponseEntity<List<Prueba>> getAllPruebas(@RequestParam(required = false) String nombre) {
		try {
			List<Prueba> pruebas = new ArrayList<Prueba>();

			if (nombre == null)
				pruebaRepository.findAll().forEach(pruebas::add);
			else
				pruebaRepository.findByNombreContaining(nombre).forEach(pruebas::add);

			if (pruebas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(pruebas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Listar por idientificador", produces = "application/json")
	@GetMapping("/pruebas/{id}")
	public ResponseEntity<Prueba> getPruebaById(@PathVariable("id") long id) {
		Optional<Prueba> pruebaData = pruebaRepository.findById(id);

		if (pruebaData.isPresent()) {
			return new ResponseEntity<>(pruebaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@ApiOperation(value = "Guardar", produces = "application/json")
	@PostMapping("/pruebas")
	public ResponseEntity<Response> createPrueba(@RequestBody Prueba prueba) {
		try {
			
			if (prueba.getDescripcion() != null && prueba.getNombre() != null) {
				Prueba _prueba = pruebaRepository
						.save(new Prueba(prueba.getNombre(), prueba.getDescripcion(), false));
				return new ResponseEntity<>(new Response("registro creado"), HttpStatus.CREATED);
				
			} else {
				return new ResponseEntity<>(new Response("registro no creado"), HttpStatus.NOT_FOUND);

			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation(value = "Actualizar", produces = "application/json")
	@PutMapping("/pruebas/{id}")
	public ResponseEntity<Prueba> updatePrueba(@PathVariable("id") long id, @RequestBody Prueba prueba) {
		Optional<Prueba> pruebaData = pruebaRepository.findById(id);

		if (pruebaData.isPresent()) {
			Prueba _prueba = pruebaData.get();
			_prueba.setNombre(prueba.getNombre());
			_prueba.setDescripcion(prueba.getDescripcion());
			_prueba.setVigente(prueba.isVigente());
			_prueba.setFechaCreacion(new Date());
			_prueba.setFechaActualizacion(new Date());
			return new ResponseEntity<>(pruebaRepository.save(_prueba), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@ApiOperation(value = "Eliminar", produces = "application/json")
	@DeleteMapping("/pruebas/{id}")
	public ResponseEntity<HttpStatus> deletePrueba(@PathVariable("id") long id) {
		try {
			pruebaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation(value = "eliminar todos", produces = "application/json")
	@DeleteMapping("/pruebas")
	public ResponseEntity<HttpStatus> deleteAllPruebas() {
		try {
			pruebaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation(value = "Listar por Vigencia", produces = "application/json")
	@GetMapping("/pruebas/vigente")
	public ResponseEntity<List<Prueba>> findByVigente() {
		try {
			List<Prueba> pruebas = pruebaRepository.findByVigente(true);

			if (pruebas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pruebas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
