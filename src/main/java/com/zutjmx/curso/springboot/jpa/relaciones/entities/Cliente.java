package com.zutjmx.curso.springboot.jpa.relaciones.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String paterno;
    private String materno;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adress> adresses;

    public Cliente() {
        this.adresses = new ArrayList<>();
    }

    public Cliente(String nombre, String paterno, String materno, String email) {
        this();
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id 
            + ", nombre=" + nombre 
            + ", paterno=" + paterno 
            + ", materno=" + materno 
            + ", email=" + email 
            + ", adresses=" + adresses + "]";
    }

}
