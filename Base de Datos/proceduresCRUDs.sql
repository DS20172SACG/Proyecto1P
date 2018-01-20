use SARES;

delimiter $$

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

create procedure cargarNombresMesas()
begin
	select nombreMesa
    from Mesa;
end$$

delimiter ;

