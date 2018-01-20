use SARES;

delimiter $$

create procedure NuevoPedidoPresencial(in cliente varchar(10), in mesero varchar(10), in mesa int, in prefe boolean, out NuevoPedido int)
begin
	INSERT INTO Pedido(EnCola, pagado, enPreparacion, cocinado, entregado, preferencial, idCliente, idMesero) 
    VALUES (0, 0, 0, 0, 0, prefe, cliente, mesero);
    
    SELECT LAST_INSERT_ID() into NuevoPedido;
    
    Insert INTO MesaPedido(idMesa, idPedido)
	values(mesa, NuevoPedido);
end$$

create procedure NuevoPedidoDomicilio(in cliente varchar(10), in mesero varchar(10), in dir varchar(255), in prefe boolean, out NuevoPedido int)
begin
	INSERT INTO Pedido(EnCola, pagado, enPreparacion, cocinado, entregado, preferencial, idCliente, idMesero) 
    VALUES (0, 0, 0, 0, 0, prefe, cliente, mesero);
    
    SELECT LAST_INSERT_ID() into NuevoPedido;
    
    insert into DireccionPedido(direccion,idPedido)
    values(dir,NuevoPedido);
end$$

create procedure IngresarDetallePedido(in num int, in idPed int, in idArt int, in cant int, in obser int)
begin
	INSERT INTO Detalle_Pedido(numDetalle, ID_Pedido, ID_Articulo, cantidad, Observaciones) 
    VALUES (num, idPed, idArt, cant, obser);
end$$

create procedure EliminarPedido(in pedido int)
begin
	delete from Pedido
    where Pedido.id = pedido;
end$$

create procedure EliminarArticuloAPedido(in pedido int, in Articulo int)
begin
	Delete from SARES.Detalle_Pedido
    where Detalle_Pedido.ID_Pedido = pedido AND Detalle_Pedido.ID_Articulo = Articulo;
end$$

Create PROCEDURE EncolarPedido(in pedido int)
begin
	update Pedido
    set Pedido.EnCola = 1
    where Pedido.id = pedido;
end$$

create procedure AgregarArticuloAPedido(in Articulo int, in Pedido int, in Cantidad int,in obs varchar(255))
begin
	INSERT INTO Detalle_Pedido(ID_Articulo, ID_Pedido, cantidad, Observaciones)
    VALUES (Articulo, Pedido, Cantidad, obs);
end$$

CREATE PROCEDURE ActualizarDetallePedido(in Articulo int, in Pedido int, in Cantidad int,in obs varchar(255))
begin
	update Detalle_Pedido
    set Detalle_Pedido.cantidad = cantidad, Detalle_Pedido.Observaciones = Obs
    where Detalle_Pedido.ID_Articulo=Articulo AND Detalle_Pedido.ID_Pedido = Pedido;
end$$

CREATE procedure AceptarPedido(in pedido int, in id int)
begin
	update Pedido
    set Pedido.idCocinero = id, Pedido.enPreparacion = 1
    where Pedido.id = pedido;
end$$

create procedure PedidoTerminado(in pedido int)
begin
	UPDATE Pedido
    set Pedido.cocinado = 1
    where Pedido.id = pedido;
end$$

create procedure FaltaIngrediente(in inArticulo int)
begin
	update Articulo
    set Articulo.Disponibilidad = 0
    where Articulo.ID = inArticulo;
end$$

delimiter ;