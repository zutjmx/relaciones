package com.zutjmx.curso.springboot.jpa.relaciones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;

    @Column(name = "numero_exterior")
    private Long numeroExterior;

    @Column(name = "numero_interior")
    private Long numeroInterior;
    
    private String ciudad;
    private String estado;
    private String pais;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Direccion() {
    }

    public Direccion(String calle, Long numeroExterior, Long numeroInterior, String ciudad, String estado, String pais, String codigoPostal) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Long getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(Long numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public Long getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(Long numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Direccion [id=" + id 
        + ", calle=" + calle 
        + ", numeroExterior=" + numeroExterior 
        + ", numeroInterior=" + numeroInterior 
        + ", ciudad=" + ciudad 
        + ", estado=" + estado 
        + ", pais=" + pais 
        + ", codigoPostal=" + codigoPostal 
        + "]";
    }
    
}
