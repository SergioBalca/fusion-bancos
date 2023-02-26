-- --------------------------------------
-- se crea el procedimiento almacenado
-- agregar_cliente
-- ---------------------------------------

use bancos_fusion;
DELIMITER //
create procedure agregar_cliente(in id_cliente varchar(10),
	nombre varchar(45),
    calle varchar(45),
    ciudad varchar(45))
    begin
		insert into cliente values (id_cliente, nombre, calle, ciudad);
    end //
    DELIMITER ;
    
-- -----------------------------------------------
-- se crea el procedimiento almacenado
-- actualizar_cliente
-- -----------------------------------------------

DELIMITER //
create procedure actualizar_cliente(in id_cliente varchar(10),
	nombre varchar(10),
    calle varchar(45),
    ciudad varchar(45))
begin
	update cliente
    set cliente.nombre_cliente = nombre,
		cliente.calle_cliente = calle,
        cliente.ciudad_cliente = ciudad
	where cliente.id = id_cliente;
end //
DELIMITER ;

