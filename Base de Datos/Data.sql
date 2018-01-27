use SARES;

INSERT INTO Cargo (idCargo, nombreCargo, eliminado) 
VALUES 	(1, 'Administrador', 0), 
		(2, 'Cocinero', 0), 
		(3, 'Mesero', 0), 
        (4, 'Repartidor', 0), 
        (5, 'Cajero', 0);

insert into Cliente (cedula, lastName, firstName, Direccion, eliminado)
values ('1234567890', 'probador', 'prueba', 'Lol', false);

INSERT INTO Categoria_Articulo (ID, Nombre) 
VALUES	(1, 'Entrada'), 
		(2, 'Plato Fuerte'), 
        (3, 'Postre'), 
        (4, 'Refresco'), 
        (5, 'Natural'),
        (6, 'Artificial');

INSERT INTO TipoDePago (ID, Tipo) 
VALUES 	(1, 'Efectivo'),  
		(2, 'Visa'), 
        (3, 'Dinero Electronico');

INSERT INTO Ambientes (idAmbiente, nombre, eliminado) 
VALUES 	(1, 'Normal', 0), 
		(2, 'VIP', 0);

INSERT INTO Mesa (idMesa, asientos, nombreMesa, disponibilidad, idAmbiente, eliminado) 
VALUES 	(1, 2,"Mesa 1", 1, 1, 0), 
		(2, 2,"Mesa 2", 1, 1, 0), 
		(3, 2,"Mesa 3", 1, 2, 0), 
        (4, 4,"Mesa 4", 1, 1, 0), 
        (5, 4,"Mesa 5", 1, 2, 0), 
        (6, 6,"Mesa 6", 1, 1, 0), 
        (7, 8,"Mesa 7", 1, 1, 0);

INSERT INTO Usuario (usuario, clave, eliminado)
VALUES 	('admin', 'superclave', 0), 
		('elcajero', '11111', 0), 
        ('elrepartidor', '22222', 0), 
        ('elmesero1', '33333', 0),
        ('elmesero2', '44444', 0),
        ('elcocinero', '12345', 0);

INSERT INTO Personal (cedula, nombres, apellidos, edad, sueldo, idCargo, usuario, eliminado) 
VALUES 	('0900000000', 'Luis', 'Arizaga', 23, 500, 1, 'admin', 0),
		('0921234567', 'Carlos Andres', 'Garcia Zambrano', 25, 350, 2, 'elcocinero', 0),
        ('0987654321', 'Alberto Luis', 'Andrade Li', 75, 300, 4, 'elrepartidor', 0), 
        ('0912873456', 'Estefany karen', 'Falconi Seto', 27, 300, 3, 'elmesero1', 0),
        ('0981237645', 'Jose Jose', 'Primero Segundo', 19, 300, 3, 'elmesero2', 0),
        ('0987612345', 'Leonardo', 'Velez', 23, 325, 5, 'elcajero', 0);

INSERT INTO Articulo (ID, Nombre, Descripcion, Precio, Disponibilidad, TiempoPreparacion, Idcategoria, eliminado) 
VALUES 	(1, 'limonada', 'jarra de limonada ', 4, 1, 3, 5, 0),
		(2, 'Jugo de Durazno', 'Jugo Artificial', 1, 1, 0, 6, 0),
		(3, 'Patacones', 'patacones con queso', 2, 1, 4, 1, 0),
        (4, 'seco de pollo', 'seco de pollo', 4, 1, 10, 2, 0),
        (5, 'Arroz marinero', 'arroz marinero', 7, 1, 13, 2, 0),
        (6, 'tres leches', 'tres leches', 3, 1, 4, 3, 0);
#modificado---------
INSERT INTO cliente (cedula,LastName, FirstName, Direccion,eliminado) 
VALUES ('0936674845','Cruz','Edward','25 y G','0'),
		('0986494824', 'Velez', 'Andres', '15  Colon', '0');

INSERT INTO pedido (id, pagado, enPreparacion, cocinado, entregado, EnCola, fecha, hora, idCliente, idMesero, idCocinero, preferencial) 
VALUES ('1', '1', '1', '1', '1', '0', '2018-01-19', '19:00', '0936674845', '0912873456', '0921234567',0),
		('2', '1', '1', '1', '1', '0', '2018-01-19', '20:00', '0986494824', '0981237645', '0921234567',1);
        
INSERT INTO detalle_pedido (ID_detalle, numDetalle, ID_Pedido, ID_Articulo,cantidad, Observaciones) 
VALUES ('1', 1, '1', '5', '1', 'ninguna'),
		('2', 1, '2','4','1','ninguna');

INSERT INTO factura (ID, TOTAL, Fecha, Id_cliente, Descuento, TipoDePago) 
VALUES ('1', '7', '2018-01-19', '0936674845', '0', '1'),
		('2', '4', '2018-01-19', '0986494824', '0', '1');
INSERT INTO detalle_factura (id_detalle, id_factura, id_pedido) 
VALUES ('1', '1', '1'),
		('2', '2', '2');
        
#modificado---------



        




