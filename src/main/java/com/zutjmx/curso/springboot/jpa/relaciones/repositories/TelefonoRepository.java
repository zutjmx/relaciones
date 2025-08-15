package com.zutjmx.curso.springboot.jpa.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Telefono;

public interface TelefonoRepository extends CrudRepository<Telefono, Long> {
    
    // Additional query methods can be defined here if needed

}
