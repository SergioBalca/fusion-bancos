package com.sofkau.models;

public class EmpleadoSubordinado {

    private String nombreSubordinado;
    private String idEmpleado;

    public EmpleadoSubordinado() {
    }

    public EmpleadoSubordinado(String nombreSubordinado, String idEmpleado) {
        this.nombreSubordinado = nombreSubordinado;
        this.idEmpleado = idEmpleado;
    }

    public String getNombreSubordinado() {
        return nombreSubordinado;
    }

    public void setNombreSubordinado(String nombreSubordinado) {
        this.nombreSubordinado = nombreSubordinado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
