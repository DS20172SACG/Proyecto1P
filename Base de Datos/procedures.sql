use Sares;

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

delimiter ;