package com.sofkau.models;

public class Prestamo {
    private String numeroPrestamo;
    private String importe;
    private String idCliente;
    private String sucursalId;

    public Prestamo() {
    }

    public Prestamo(String numeroPrestamo, String importe, String idCliente, String sucursalId) {
        this.numeroPrestamo = numeroPrestamo;
        this.importe = importe;
        this.idCliente = idCliente;
        this.sucursalId = sucursalId;
    }

    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(String numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }
}
