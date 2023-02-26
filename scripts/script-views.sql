use bancos_fusion;


-- ---------------------------------
-- se crea vista productos_cliente
-- ----------------------------------
create view productos_cliente as
select cliente.nombre_cliente, prestamo.importe as importe_prestamo, cuenta.numero_cuenta, cuenta.saldo as saldo_cuenta
from cliente
inner join prestamo on cliente.id = prestamo.id_cliente
inner join cuenta on cliente.id = cuenta.Cliente_id_cliente;

-- -----------------------------------
-- se crea la vista pagos_prestamo
-- -----------------------------------
use bancos_fusion;
create view pagos_prestamo as
select cliente.nombre_cliente, prestamo.importe as importe_prestamo, Pago.fecha_pago, Pago.importe_pagado
from cliente
inner join prestamo on cliente.id = prestamo.id_cliente
inner join pago on prestamo.numero_prestamo = pago.Prestamo_numero_prestamo;

