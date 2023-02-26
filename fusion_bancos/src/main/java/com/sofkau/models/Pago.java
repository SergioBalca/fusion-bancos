package com.sofkau.models;

public class Pago {

    private String numeroPago;
    private String fechaPago;
    private String importePagado;
    private String prestamoNumeroPrestamo;

    public Pago() {
    }

    public Pago(String numeroPago, String fechaPago, String importePagado, String prestamoNumeroPrestamo) {
        this.numeroPago = numeroPago;
        this.fechaPago = fechaPago;
        this.importePagado = importePagado;
        this.prestamoNumeroPrestamo = prestamoNumeroPrestamo;
    }

    public String getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(String numeroPago) {
        this.numeroPago = numeroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(String importePagado) {
        this.importePagado = importePagado;
    }

    public String getPrestamoNumeroPrestamo() {
        return prestamoNumeroPrestamo;
    }

    public void setPrestamoNumeroPrestamo(String prestamoNumeroPrestamo) {
        this.prestamoNumeroPrestamo = prestamoNumeroPrestamo;
    }
}
