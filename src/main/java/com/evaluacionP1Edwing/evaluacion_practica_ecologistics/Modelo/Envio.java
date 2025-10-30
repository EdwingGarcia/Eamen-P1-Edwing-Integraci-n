package com.evaluacionP1Edwing.evaluacion_practica_ecologistics.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Envio {
    @JsonProperty("id")
    private String id;
    private String cliente;
    private String direccion;
    private String estado;

    public Envio() {}

    public Envio(String id, String cliente, String direccion, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

