package com.zutjmx.curso.springboot.jpa.relaciones.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Adress;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Cliente;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Direccion;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Factura;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Persona;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Telefono;

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
        return faker.number().numberBetween(1L, 100L);
    }

    public Persona getPersona() {
        Persona persona = new Persona();
        persona.setNombre(faker.name().firstName());
        persona.setPaterno(faker.name().lastName());
        persona.setMaterno(faker.name().lastName());        
        persona.setEmail(faker.internet().emailAddress());
        persona.setLenguajeProgramacion(faker.programmingLanguage().name());
        persona.setFechaCreacion(LocalDateTime.now());
        return persona;
    }

    public Direccion getDireccion(Persona persona) {
        Direccion direccion = new Direccion();
        direccion.setCalle(faker.address().streetName());
        direccion.setNumeroExterior(faker.number().numberBetween(1L, 1000L));
        direccion.setNumeroInterior(faker.number().numberBetween(1L, 1000L));
        direccion.setCiudad(faker.address().city());
        direccion.setEstado(faker.address().state());
        direccion.setCodigoPostal(faker.address().zipCode());
        direccion.setPais(faker.address().country());
        direccion.setPersona(persona);
        return direccion;
    }

    public List<Adress> getAdresses(int count) {
        List<Adress> adresses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            adresses.add(new Adress(
                faker.address().streetName(),
                faker.number().numberBetween(1, 100),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country()
            ));
        }
        return adresses;
    }

    public List<Telefono> getTelefonos(int count) {
        List<Telefono> telefonos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Telefono telefono = new Telefono();
            telefono.setNumero(faker.phoneNumber().phoneNumber());
            telefono.setTipo(faker.options().option("Casa", "Trabajo", "Movil"));
            telefonos.add(telefono);
        }
        return telefonos;
    }
}
