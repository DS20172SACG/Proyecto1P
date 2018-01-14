use SARES;

INSERT INTO Cargo (idCargo, nombreCargo, eliminado) 
VALUES (1, 'Administrador', 0), (2, 'Cocinero', 0), (3, 'Mesero', 0), (4, 'Repartidor', 0), (5, 'Cajero', 0);


INSERT INTO Categoria_Articulo (ID, Nombre) 
VALUES (1, 'Entrada'), (2, 'Plato Fuerte'), (3, 'Postre'), (4, 'Refresco'), (5, 'Natural'),(6, 'Artificial');

INSERT INTO TipoDePago (ID, Tipo) 
VALUES (1, 'Efectivo'),  (2, 'Visa'), (3, 'Dinero Electronico');

INSERT INTO Ambientes (idAmbiente, nombre, eliminado) 
VALUES (1, 'Normal', 0), (2, 'VIP', 0);

INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) 
VALUES (1, 2, 1, 1, 0), (2, 2, 1, 1, 0), (3, 2, 1, 2, 0), (4, 4, 1, 1, 0), (5, 4, 1, 2, 0), (6, 6, 1, 1, 0), (7, 8, 1, 1, 0);

INSERT INTO Usuario (usuario, clave) 
VALUES ('admin', 'superclave'), ('elcajero', '11111'), ('elrepartidor', '22222'), ('elmesero1', '33333'),('elmesero2', '44444'),('elcocinero', '12345');

INSERT INTO Personal (cedula, nombres, apellidos, edad, sueldo, idCargo, usuario, eliminado) 
VALUES ('0900000000', 'Luis', 'Arizaga', 23, 500, 1, 'admin', 0),
		('0921234567', 'Carlos Andres', 'Garcia Zambrano', 25, 350, 2, 'elcocinero', 0),
        ('0987654321', 'Alberto Luis', 'Andrade Li', 75, 300, 4, 'elrepartidor', 0), 
        ('0912873456', 'Estefany karen', 'Falconi Seto', 27, 300, 3, 'elmesero1', 0),
        ('0981237645', 'Jose Jose', 'Primero Segundo', 19, 300, 3, 'elmesero2', 0),
        ('0987612345', 'Leonardo', 'Velez', 23, 325, 5, 'elcajero', 0);


