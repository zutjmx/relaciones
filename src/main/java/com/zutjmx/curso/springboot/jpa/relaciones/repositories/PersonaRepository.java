package com.zutjmx.curso.springboot.jpa.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
