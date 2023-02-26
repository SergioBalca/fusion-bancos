package com.sofkau.models;

public class ClienteEmpleado {

    private String clienteId;
    private String empleadoId;
    private String tipo;

    public ClienteEmpleado() {
    }

    public ClienteEmpleado(String clienteId, String empleadoId, String tipo) {
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
        this.tipo = tipo;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
