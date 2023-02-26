package com.sofkau.models;

public class Cuenta {

    private String numeroCuenta;
    private String saldo;
    private String clienteIdCliente;
    private String fechaAcceso;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, String saldo, String clienteIdCliente, String fechaAcceso) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.clienteIdCliente = clienteIdCliente;
        this.fechaAcceso = fechaAcceso;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(String clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public String getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(String fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }
}
