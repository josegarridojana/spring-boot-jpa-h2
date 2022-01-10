package com.prueba.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.spring.jpa.h2.model.Prueba;

public interface PruebaRepository extends JpaRepository<Prueba, Long> {
  List<Prueba> findByVigente(boolean vigente);

  List<Prueba> findByNombreContaining(String nombre);
}
