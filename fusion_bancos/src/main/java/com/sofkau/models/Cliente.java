package com.sofkau.models;

public class Cliente {
    private String id;
    private String nombreCliente;
    private String calleCliente;
    private String ciudadCliente;

    public Cliente() {
    }

    public Cliente(String id, String nombreCliente, String calleCliente, String ciudadCliente) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.calleCliente = calleCliente;
        this.ciudadCliente = ciudadCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCalleCliente() {
        return calleCliente;
    }

    public void setCalleCliente(String calleCliente) {
        this.calleCliente = calleCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }
}
