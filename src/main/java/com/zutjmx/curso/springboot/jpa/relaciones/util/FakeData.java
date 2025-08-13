package com.zutjmx.curso.springboot.jpa.relaciones.util;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Cliente;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Factura;

@Component
public class FakeData {

    private Faker faker = new Faker();

    public Cliente crearClienteFalso() {
        Cliente cliente = new Cliente();
        cliente.setNombre(faker.name().firstName());
        cliente.setPaterno(faker.name().lastName());
        cliente.setMaterno(faker.name().lastName());
        cliente.setEmail(faker.internet().emailAddress());
        return cliente;
    }

    public Factura crearFacturaFalsa(Cliente cliente) {
        Factura factura = new Factura();
        factura.setDescripcion(faker.commerce().productName());
        factura.setTotal(faker.number().numberBetween(100L, 1000L));
        factura.setCliente(cliente);
        return factura;
    }

    public Long generaIdClienteAleatorio() {
        // Aquí puedes implementar la lógica para generar un ID de cliente aleatorio
        // Por ejemplo, podrías devolver un ID existente de la base de datos o generar uno nuevo
        return faker.number().numberBetween(1L, 100L);
    }
}
