package com.sofkau.models;

public class Sucursal {

    private String id;
    private String nombreSucursal;
    private String ciudadSucursal;
    private String activo;

    public Sucursal() {
    }

    public Sucursal(String id, String nombreSucursal, String ciudadSucursal, String activo) {
        this.id = id;
        this.nombreSucursal = nombreSucursal;
        this.ciudadSucursal = ciudadSucursal;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCiudadSucursal() {
        return ciudadSucursal;
    }

    public void setCiudadSucursal(String ciudadSucursal) {
        this.ciudadSucursal = ciudadSucursal;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
