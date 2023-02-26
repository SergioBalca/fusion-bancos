-- ----------------------------------------
-- se crea la tabla control_cambios_banco
-- ----------------------------------------

use bancos_fusion;

create table control_cambios_banco (
	usuario varchar(45) not null,
    accion varchar(45) not null,
    fecha datetime default current_timestamp
);

-- ------------------------------------------------------------------
-- se crea el trigger on_insert_cliente
-- el cual se activa cuando se agrega un registro en la tabla cliente
-- ------------------------------------------------------------------

DELIMITER //
create trigger on_insert_cliente after insert on bancos_fusion.cliente
for each row
begin
	insert into control_cambios_banco
    values (user(), "Agregó cliente", now());
end //
DELIMITER ;
