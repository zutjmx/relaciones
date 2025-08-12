package com.zutjmx.curso.springboot.jpa.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
    // Additional query methods can be defined here if needed

    // Example: Find by email
    Cliente findByEmail(String email);

}
