package com.zutjmx.curso.springboot.jpa.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Direccion;

public interface DireccionRepository extends CrudRepository<Direccion, Long> {
    
}
