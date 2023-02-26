package com.sofkau.models;

public class CuentaCorriente {

    private String id;
    private String descubierto;
    private String cuentaNumeroCuenta;

    public CuentaCorriente() {
    }

    public CuentaCorriente(String id, String descubierto, String cuentaNumeroCuenta) {
        this.id = id;
        this.descubierto = descubierto;
        this.cuentaNumeroCuenta = cuentaNumeroCuenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(String descubierto) {
        this.descubierto = descubierto;
    }

    public String getCuentaNumeroCuenta() {
        return cuentaNumeroCuenta;
    }

    public void setCuentaNumeroCuenta(String cuentaNumeroCuenta) {
        this.cuentaNumeroCuenta = cuentaNumeroCuenta;
    }
}
