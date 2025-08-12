package com.zutjmx.curso.springboot.jpa.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
