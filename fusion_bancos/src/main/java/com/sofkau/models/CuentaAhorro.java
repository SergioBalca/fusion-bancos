package com.sofkau.models;

public class CuentaAhorro {

    private String id;
    private String tipoInteres;
    private String cuentaIdCuenta;

    public CuentaAhorro() {
    }

    public CuentaAhorro(String id, String tipoInteres, String cuentaIdCuenta) {
        this.id = id;
        this.tipoInteres = tipoInteres;
        this.cuentaIdCuenta = cuentaIdCuenta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(String tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public String getCuentaIdCuenta() {
        return cuentaIdCuenta;
    }

    public void setCuentaIdCuenta(String cuentaIdCuenta) {
        this.cuentaIdCuenta = cuentaIdCuenta;
    }
}
