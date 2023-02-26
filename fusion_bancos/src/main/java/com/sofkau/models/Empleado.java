package com.sofkau.models;

public class Empleado {

    private String id;
    private String fechaComienzo;
    private String numeroTelefono;
    private String nombre;

    public Empleado() {
    }

    public Empleado(String id, String fechaComienzo, String numeroTelefono, String nombre) {
        this.id = id;
        this.fechaComienzo = fechaComienzo;
        this.numeroTelefono = numeroTelefono;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(String fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
