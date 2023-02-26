package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.models.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

public class Main {
    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "bancos_fusion";
    private static final String USER = "root";
    private static final String PASSWORD = "Tech2022camp";
    private static final MySqlOperation mySqlOperation = new MySqlOperation();
    public static int registros = 5;
    public static List<String> idCliente = new ArrayList<>();
    public static List<String> idEmpleado = new ArrayList<>();
    public static List<String> idCuenta = new ArrayList<>();
    public static List<String> idPrestamo = new ArrayList<>();
    public static List<String> idSucursal = new ArrayList<>();

    public static void main(String[] args) {
        openConnection();
        List<String> idClientes = insertCliente();
        List<String> idEmpleados = insertEmpleado();
        List<String> idSucursales = insertSucursal();
        List<String> idPrestamos = insertPrestamo(idClientes, idSucursales);
        insertPago(idPrestamos);
        List<String> idCuentas = insertCuenta(idClientes);
        insertCuentaCorriente(idCuentas);
        insertCuentaAhorro(idCuentas);
        insertEmpleadoSubordinado(idEmpleados);
        insertClienteEmpleado(idClientes, idEmpleados);
    }

    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void closeConnection() {
        mySqlOperation.close();
    }

    public static List<String> insertCliente(){
        String statementInsertCliente = "";

        for (int i = 0; i < registros; i++){
            Cliente cliente = new Cliente();
            Faker faker = new Faker();

            cliente.setId("cliente" + i);
            cliente.setNombreCliente(faker.name().firstName() + faker.name().lastName());
            cliente.setCalleCliente(faker.address().streetName());
            cliente.setCiudadCliente("Medellin");

            statementInsertCliente = String.format("insert into cliente(id, nombre_cliente, calle_cliente, ciudad_cliente)  " +
                    "values('%s', '%s', '%s', '%s');",
                    cliente.getId(),
                    cliente.getNombreCliente(),
                    cliente.getCalleCliente(),
                    cliente.getCiudadCliente());

            mySqlOperation.setSqlStatement(statementInsertCliente);
            mySqlOperation.executeInsertStatement();
            idCliente.add(cliente.getId());
        }
        return idCliente;
    }

    public static List<String> insertEmpleado(){
        String statementInsertEmpleado = "";

        for (int i = 0; i < registros; i++){
            Empleado empleado = new Empleado();
            Faker faker = new Faker();

            empleado.setId("EMP" + i);
            empleado.setFechaComienzo(valueOf(faker.date().between(Date.from(LocalDate.of(2022, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            empleado.setNumeroTelefono("604" + faker.numerify("#####"));
            empleado.setNombre(faker.name().firstName() + faker.name().lastName());

            statementInsertEmpleado = String.format("insert into empleado(id, fecha_comienzo, numero_telefono, nombre)" +
                    "values ('%s', '%s', '%s', '%s');",
                    empleado.getId(),
                    empleado.getFechaComienzo(),
                    empleado.getNumeroTelefono(),
                    empleado.getNombre());
            mySqlOperation.setSqlStatement(statementInsertEmpleado);
            mySqlOperation.executeInsertStatement();
            idEmpleado.add(empleado.getId());
        }
        return idEmpleado;
    }

    public static List<String> insertSucursal(){
        String statementInsertSucursal = "";

        for (int i = 0; i < registros; i++){
            Sucursal sucursal = new Sucursal();
            Faker faker = new Faker();

            sucursal.setId("SUC-" + i);
            sucursal.setNombreSucursal(faker.address().streetName());
            sucursal.setCiudadSucursal(faker.address().cityName());
            sucursal.setActivo(faker.numerify("######"));

            statementInsertSucursal = String.format("insert into sucursal (id, nombre_sucursal, ciudad_sucursal, activo)" +
                    "values ('%s', '%s', '%s', '%s');",
                    sucursal.getId(),
                    sucursal.getNombreSucursal(),
                    sucursal.getCiudadSucursal(),
                    sucursal.getActivo());

            mySqlOperation.setSqlStatement(statementInsertSucursal);
            mySqlOperation.executeInsertStatement();
            idSucursal.add(sucursal.getId());
        }
        return idSucursal;
    }

    public static List<String> insertPrestamo(List<String> idClientes, List<String> idSucursales){
        String statementInsertPrestamo = "";

        for (int i = 0; i < registros; i++){
            Prestamo prestamo = new Prestamo();
            Faker faker = new Faker();

            prestamo.setNumeroPrestamo("PREST-" + i);
            prestamo.setImporte(faker.numerify("#######"));
            prestamo.setIdCliente(idClientes.get(i));
            prestamo.setSucursalId(idSucursales.get(i));

            statementInsertPrestamo = String.format("insert into prestamo (numero_prestamo, importe, id_cliente, sucursal_id)" +
                    "values ('%s', '%s', '%s', '%s');",
                    prestamo.getNumeroPrestamo(),
                    prestamo.getImporte(),
                    prestamo.getIdCliente(),
                    prestamo.getSucursalId());

            mySqlOperation.setSqlStatement(statementInsertPrestamo);
            mySqlOperation.executeInsertStatement();
            idPrestamo.add(prestamo.getNumeroPrestamo());
        }
        return idPrestamo;
    }

    public static void insertPago(List<String> idPrestamos){
        String statementInsertPago = "";

        for (int i = 0; i < registros; i++){
            Pago pago = new Pago();
            Faker faker = new Faker();

            pago.setNumeroPago("Pago#" + i);
            pago.setFechaPago(valueOf(faker.date().between(Date.from(LocalDate.of(2022, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            pago.setImportePagado(faker.numerify("######"));
            pago.setPrestamoNumeroPrestamo(idPrestamos.get(i));

            statementInsertPago = String.format("insert into pago (numero_pago, fecha_pago, importe_pagado, prestamo_numero_prestamo)" +
                    "values ('%s', '%s', '%s', '%s');",
                    pago.getNumeroPago(),
                    pago.getFechaPago(),
                    pago.getImportePagado(),
                    pago.getPrestamoNumeroPrestamo());

            mySqlOperation.setSqlStatement(statementInsertPago);
            mySqlOperation.executeInsertStatement();

        }
    }

    public static List<String> insertCuenta(List<String> idClientes){
        String statementInsertCuenta = "";

        for (int i = 0; i < registros; i++){
            Cuenta cuenta = new Cuenta();
            Faker faker = new Faker();

            cuenta.setNumeroCuenta(faker.numerify("####"));
            cuenta.setSaldo(faker.numerify("#######"));
            cuenta.setFechaAcceso(valueOf(faker.date().between(Date.from(LocalDate.of(2022, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date())));
            cuenta.setClienteIdCliente(idClientes.get(i));

            statementInsertCuenta = String.format("insert into cuenta (numero_cuenta, saldo, fecha_acceso, cliente_id_cliente)" +
                    "values ('%s', '%s', '%s', '%s');",
                    cuenta.getNumeroCuenta(),
                    cuenta.getSaldo(),
                    cuenta.getFechaAcceso(),
                    cuenta.getClienteIdCliente());

            mySqlOperation.setSqlStatement(statementInsertCuenta);
            mySqlOperation.executeInsertStatement();
            idCuenta.add(cuenta.getNumeroCuenta());
        }
        return idCuenta;
    }

    public static void insertCuentaCorriente(List<String> idCuentas){
        String statementInsertCuentaCorriente = "";

        for (int i = 0; i < registros; i++){
            CuentaCorriente cuentaCorriente = new CuentaCorriente();
            Faker faker = new Faker();

            cuentaCorriente.setId("CC#" + i);
            cuentaCorriente.setDescubierto(faker.numerify("#######"));
            cuentaCorriente.setCuentaNumeroCuenta(idCuentas.get(i));

            statementInsertCuentaCorriente = String.format("insert into cuenta_corriente (id, descubierto, cuenta_numero_cuenta)" +
                    "values ('%s', '%s', '%s');",
                    cuentaCorriente.getId(),
                    cuentaCorriente.getDescubierto(),
                    cuentaCorriente.getCuentaNumeroCuenta());

            mySqlOperation.setSqlStatement(statementInsertCuentaCorriente);
            mySqlOperation.executeInsertStatement();
        }
    }

    public static void insertCuentaAhorro(List<String> idCuentas){
        String statementInsertCuentaAhorro = "";

        for (int i = 0; i < registros; i++){
            CuentaAhorro cuentaAhorro = new CuentaAhorro();
            Faker faker = new Faker();

            cuentaAhorro.setId("CA#" + i);
            cuentaAhorro.setTipoInteres(faker.numerify("#.#"));
            cuentaAhorro.setCuentaIdCuenta(idCuentas.get(i));

            statementInsertCuentaAhorro = String.format("insert into cuenta_ahorro (id, tipo_interes, cuenta_id_cuenta)" +
                    "values ('%s', '%s', '%s');",
                    cuentaAhorro.getId(),
                    cuentaAhorro.getTipoInteres(),
                    cuentaAhorro.getCuentaIdCuenta());

            mySqlOperation.setSqlStatement(statementInsertCuentaAhorro);
            mySqlOperation.executeInsertStatement();
        }
    }

    public static void insertEmpleadoSubordinado(List<String> idEmpleados){
        String statementInsertEmpeladoSubordinado = "";

        for (int i = 0; i < registros; i++){
            EmpleadoSubordinado empleadoSubordinado = new EmpleadoSubordinado();
            Faker faker = new Faker();

            empleadoSubordinado.setNombreSubordinado(faker.name().firstName() + faker.name().lastName());
            empleadoSubordinado.setIdEmpleado(idEmpleados.get(i));

            statementInsertEmpeladoSubordinado = String.format("insert into empleado_subordinado (nombre_subordinado, id_empleado)" +
                    "values ('%s', '%s');",
                    empleadoSubordinado.getNombreSubordinado(),
                    empleadoSubordinado.getIdEmpleado());

            mySqlOperation.setSqlStatement(statementInsertEmpeladoSubordinado);
            mySqlOperation.executeInsertStatement();
        }
    }

    public static void insertClienteEmpleado(List<String> idClientes, List<String> idEmpleados){
        String statementInsertClienteEmpleado = "";

        for (int i = 0; i < registros; i++){
            ClienteEmpleado clienteEmpleado = new ClienteEmpleado();
            Faker faker = new Faker();

            clienteEmpleado.setClienteId(idClientes.get(i));
            clienteEmpleado.setEmpleadoId(idEmpleados.get(i));

            statementInsertClienteEmpleado = String.format("insert into cliente_empleado (cliente_id, empleado_id)" +
                    "values ('%s', '%s');",
                    clienteEmpleado.getClienteId(),
                    clienteEmpleado.getEmpleadoId());

            mySqlOperation.setSqlStatement(statementInsertClienteEmpleado);
            mySqlOperation.executeInsertStatement();
        }
    }


}