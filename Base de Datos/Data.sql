use SARES;

INSERT INTO Cargo (idCargo, nombreCargo, eliminado) VALUES (1, 'Administrador', 0);
INSERT INTO Cargo (idCargo, nombreCargo, eliminado) VALUES (2, 'Cocinero', 0);
INSERT INTO Cargo (idCargo, nombreCargo, eliminado) VALUES (3, 'Mesero', 0);
INSERT INTO Cargo (idCargo, nombreCargo, eliminado) VALUES (4, 'Repartidor', 0);
INSERT INTO Cargo (idCargo, nombreCargo, eliminado) VALUES (5, 'Cajero', 0);

INSERT INTO Categoria_Articulo (ID, Nombre) VALUES (1, 'Entrada');
INSERT INTO Categoria_Articulo (ID, Nombre) VALUES (2, 'Plato Fuerte');
INSERT INTO Categoria_Articulo (ID, Nombre) VALUES (3, 'Postre');
INSERT INTO Categoria_Articulo (ID, Nombre) VALUES (4, 'Refresco');
INSERT INTO Categoria_Articulo (ID, Nombre) VALUES (5, 'Natural');
INSERT INTO Categoria_Articulo (ID, Nombre) VALUES (6, 'Artificial');

INSERT INTO TipoDePago (ID, Tipo) VALUES (1, 'Efectivo');
INSERT INTO TipoDePago (ID, Tipo) VALUES (2, 'Visa');
INSERT INTO TipoDePago (ID, Tipo) VALUES (3, 'Dinero Electronico');

INSERT INTO Ambientes (idAmbiente, nombre, eliminado) VALUES (1, 'Normal', 0);
INSERT INTO Ambientes (idAmbiente, nombre, eliminado) VALUES (2, 'VIP', 0);

INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (1, 2, 1, 1, 0);
INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (2, 2, 1, 1, 0);
INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (3, 2, 1, 2, 0);
INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (4, 4, 1, 1, 0);
INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (5, 4, 1, 2, 0);
INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (6, 6, 1, 1, 0);
INSERT INTO Mesa (idMesa, asientos, disponibilidad, idAmbiente, eliminado) VALUES (7, 8, 1, 1, 0);


