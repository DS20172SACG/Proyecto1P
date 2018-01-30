use SARES;

delimiter $$
create procedure cargarContrasenaPorUsuario(in nombreArticulo varchar(255))
begin
	select clave
    from usuario
    where usuario = nombreArticulo;
end$$

create procedure buscarIdentificaciondeCargo(in cadena varchar(255))
begin
	select *
    from cargo
    where nombreCargo = cadena;
end$$

create procedure buscarUsuario(in cadena varchar(255))
begin
	select *
    from Usuario
    where usuario = cadena;
end$$

create procedure verificarUsuarioContrasena(in inUsuario varchar(255), in inContrasena varchar(255))
begin
	select *
    from Usuario
    where usuario = inUsuario and clave = inContrasena;
end$$

create procedure ObtenerPersonalPorUsuario(in cadena varchar(255))
begin
	select *
    from Personal
    where usuario = cadena;
end$$

create procedure AgregarUsuario(in usuario varchar(255), IN contraseña VARCHAR(255))
begin
	INSERT INTO Usuario (usuario, clave, eliminado)
	VALUES 	(usuario, contraseña, 0);
end$$

create procedure EliminarUsuario(in usuario varchar(255))
begin
	update Usuario
	set eliminado=1
    where Usuario.usuario = usuario;
end$$

create procedure CambiarContraseña(in usuario varchar(255), IN contraseña VARCHAR(255))
begin
	update Usuario 
	set clave=contraseña
	where Usuario.clave = contraseña; 
end$$

create procedure CambiarUsuario(in usuario varchar(255), IN nuevo VARCHAR(255))
begin
	update Usuario 
	set Usuario.usuario = nuevo
	where Usuario.usuario = usuario; 
end$$

create procedure AgregarAmbiente(in Nombre varchar(255))
begin
	INSERT INTO Ambientes (nombre, eliminado)
	VALUES 	(Nombre, 0);
end$$

create procedure EliminarAmbiente(in id INT)
begin
	update Ambientes
	set eliminado=1
    where Ambientes.idAmbiente = id;
end$$

create procedure ActualizarAmbiente(in Nombre varchar(255), in nuevo varchar(255))
begin
	update Ambientes
	set Ambientes.nombre = nuevo
    where Ambientes.nombre = Nombre;
end$$

create procedure VerAmbientes()
begin
	select * from Ambientes;
end$$

create procedure AgregarMesa(in inAsientos int, in inAmbiente int)
begin
	INSERT INTO Sares.Mesa (asientos, disponibilidad, idAmbientes, eliminado)
	VALUES 	(inAsientos, 1, inAmbiente, 0);
end$$

create procedure EliminarMesa(in id INT)
begin
	update Mesa
	set Mesa.eliminado=1
    where Mesa.idMesa = id;
end$$

create procedure ActualizarMesa(in id int, in Asientos int, in Disponibilidad tinyint, in Ambiente int)
begin


	update Mesa
	set Mesa.asientos = Asientos, Mesa.disponibilidad = Disponibilidad, Mesa.idAmbiente = Ambiente
    where Mesa.idMesa = id;
end$$

create procedure VerMesas()
begin
	select * from Mesa;
end$$

create procedure cargarArticuloPorCategoria(in categoria int)
begin
	select *
    from Articulo
    where IdCategoria = categoria and eliminado = 0;
end$$

create procedure cargarDescripcionArticuloPorNombre(in nombreArticulo varchar(255))
begin
	select Descripcion
    from Articulo
    where Nombre = nombreArticulo;
end$$

create procedure cargarPrecioArticuloPorNombre(in nombreArticulo varchar(255))
begin
	select Precio
    from Articulo
    where Nombre = nombreArticulo;
end$$

CREATE procedure cargarListaClientes()
begin
	Select Cliente.cedula, Cliente.FirstName, Cliente.LastName, Cliente.Direccion
	from Cliente
    where Cliente.eliminado = 0;
end$$

CREATE procedure cargarListaClientesPendientes()
begin
	Select DISTINCT Cliente.cedula, Cliente.FirstName, Cliente.LastName, Cliente.Direccion
	from Cliente, Pedido
    where Cliente.eliminado = 0 and Pedido.pagado = 0 and Cliente.cedula = Pedido.idCliente;
end$$

create procedure cargarNombresMesas()
begin
	select nombreMesa
    from Mesa;
end$$

create procedure idMesaPorNombre(in nombre varchar(255))
begin
	select idMesa
    from Mesa
    where nombreMesa = nombre;
end$$

create procedure idArticuloPorNombre(in art varchar(255))
begin
	select id
    from Articulo
    where nombre = art;
end$$

CREATE PROCEDURE cargarListaIdPedidosNoPagados(in cedula varchar(10))
begin
	Select DISTINCT SARES.Pedido.id
	from Detalle_Pedido, Pedido
    where Pedido.pagado = 0 AND Detalle_Pedido.ID_Pedido = Pedido.id AND Pedido.idCliente = cedula;
end$$

CREATE PROCEDURE cargarInfoPedidos(in ped int)
begin
	Select Articulo.ID, Articulo.Nombre, Detalle_Pedido.cantidad, Detalle_Pedido.cantidad * Articulo.Precio, Pedido.idCliente
	from Detalle_Pedido, Pedido, Articulo
    where Pedido.pagado = 0 AND Detalle_Pedido.ID_Pedido = ped AND Pedido.id=ped AND Detalle_Pedido.ID_Articulo = Articulo.ID;
end$$

create procedure pedidosNoAtendidosDeCliente(in cedula varchar(255))
begin
	select *
    from Pedido
    where IdCocinero is null and idCliente = cedula;
end$$

create procedure obtenerDireccionEntregaPedido(in idPed int)
begin
	select direccion
    from DireccionPedido
    where idPedido = idPed;
end$$

create procedure obtenerDetalleDePedido(in idPed int)
begin
	select *
    from Detalle_Pedido
    where ID_Pedido = idPed;
end$$

create procedure obtenerDetalleDePedidoParaTabla(in idPed int)
begin
	select d.numDetalle,a.nombre,d.cantidad,a.Precio
    from Detalle_Pedido d join Articulo a
    where d.ID_Articulo = a.ID and d.ID_Pedido = idPed;
end$$

create procedure obtenerMesaDePedido(in idPed int)
begin
	select idMesa
    from MesaPedido
    where idPedido = idPed;
end$$

delimiter ;

