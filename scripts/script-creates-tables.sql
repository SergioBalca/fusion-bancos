use bancos_fusion;

-- ----------------------------------
-- Se crea la tabla Cliente
-- ----------------------------------

create table cliente (
	id varchar(10) not null,
    nombre_cliente varchar(45) not null,
    calle_cliente varchar(45) null,
    ciudad_cliente varchar(45) null,
    primary key (id));
    
-- -------------------------------------
-- se crea la tabla Empleado
-- ------------------------------------

create table empleado (
	id varchar(10) not null,
    fecha_comienzo varchar(45) not null,
    numero_telefono varchar(15) null,
    nombre varchar(45) not null,
    primary key (id));
    
-- --------------------------------
-- se crea la tabla Sucursal
-- -------------------------------

create table sucursal (
	id varchar(10) not null,
    nombre_sucursal varchar(45) not null,
    ciudad_sucursal varchar(45) not null,
    activo int null,
    primary key (id));
    
-- ----------------------------
-- Se crea la tabla Prestamo
-- ----------------------------

create table prestamo (
	numero_prestamo varchar(10) not null,
    importe int not null,
    id_cliente varchar(10) not null,
    sucursal_id varchar(10) not null,
    primary key(numero_prestamo),
    foreign key (id_cliente) references cliente (id),
    foreign key (sucursal_id) references sucursal (id));
    
-- -----------------------------------
-- se crea la tabla Pago
-- ----------------------------------

create table pago (
	numero_pago varchar(10) not null,
    fecha_pago varchar(45) not null,
    importe_pagado int not null,
    Prestamo_numero_prestamo varchar(10) not null,
    primary key (numero_pago, Prestamo_numero_prestamo),
    foreign key (Prestamo_numero_prestamo) references prestamo (numero_prestamo));
    
-- ----------------------------------------
-- se crea la tabla Cuenta
-- ----------------------------------------

create table Cuenta (
	numero_cuenta varchar(10) not null,
    saldo int not null,
    fecha_acceso varchar(45) null,
    Cliente_id_cliente varchar(10) not null,
    primary key (numero_cuenta),
    foreign key (Cliente_id_cliente) references cliente (id));
    
-- ---------------------------------------
-- se crea la tabla Cuenta_corriente
-- --------------------------------------

create table cuenta_corriente (
	id varchar(10) not null,
    descubierto int not null,
    Cuenta_numero_cuenta varchar(10) not null,
    primary key (id),
    foreign key (Cuenta_numero_cuenta) references Cuenta (numero_cuenta));
    
-- ------------------------------
-- se crea la tabla cuenta_ahorro
-- -------------------------------

create table cuenta_ahorro (
	id varchar(10) not null,
    tipo_interes int not null,
    Cuenta_id_cuenta varchar(10),
    primary key (id),
    foreign key (Cuenta_id_cuenta) references Cuenta (numero_cuenta));
    
-- --------------------------------------
-- se crea la tabla empleado_subordinado
-- ---------------------------------------

create table empleado_subordinado (
	nombre_subordinado varchar(45) not null,
    id_empleado varchar(10) not null,
    primary key (id_empleado, nombre_subordinado),
    foreign key (id_empleado) references Empleado (id));
    
-- ----------------------------------------------
-- se crea la tabla cliente_empleado
-- ---------------------------------------------

create table cliente_empleado (
	Cliente_id varchar(10) not null,
    empleado_id varchar(10) not null,
    tipo varchar(45) null,
    primary key (Cliente_id, empleado_id),
    foreign key (Cliente_id) references Cliente (id),
    foreign key (empleado_id) references Empleado (id));
    
    
