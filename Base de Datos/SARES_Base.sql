DROP DATABASE SARES;

CREATE DATABASE SARES;
USE SARES;
CREATE TABLE Cliente (
    ID int NOT NULL,
    Cedula varchar(10), 
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Direccion varchar(255),
    PRIMARY KEY (ID)
    
); 
CREATE TABLE Categoria_Personal (

    ID int NOT NULL,
    Nombre varchar(255) NOT NULL,
    
    PRIMARY KEY (ID)
    
); 
CREATE TABLE Personal (
    ID varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    ID_categoria int NOT NULL,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_categoria) references Categoria_Personal(ID)
); 
CREATE TABLE Categoria_Articulo(
	ID int NOT NULL,
    Nombre VARCHAR(255),
    Descripcion VARCHAR(255),
    
    PRIMARY KEY(ID)
);
CREATE TABLE Articulo(

	ID int NOT NULL,
    Nombre VARCHAR(255),
    Descripcion VARCHAR(255),
    
    Precio DOUBLE,
    Disponibilidad boolean,
	TiempoPreparacion int,
    Idcategoria int,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (Idcategoria) references Categoria_Articulo(ID)
);
CREATE TABLE Estado_Pedido(
	ID int NOT NULL,
    Estado nvarchar(30) NOT NULL,
    
    PRIMARY KEY (ID)
    
);
CREATE TABLE Pedido (
    ID int NOT NULL,
    
    Preferencial boolean,
    ID_estado int,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_estado) references Estado_Pedido(ID)
); 
CREATE TABLE Detalle_Pedido(


	ID_detalle int NOT NULL,
    ID_Pedido int NOT NULL,
    ID_Articulo int NOT NULL,
    cantidad int,
    Observaciones varchar(255),
    
    
    PRIMARY KEY (ID_detalle),
    FOREIGN KEY (ID_Pedido) references Pedido(ID)
);
CREATE TABLE TipoDePago(
	ID int,
    Tipo varchar(30),
    
    PRIMARY KEY (ID)
);
CREATE TABLE Factura (
    ID int NOT NULL,
    TOTAL double,
    Fecha DATE,
    Id_cliente int,
    Descuento int,
    TipoDePago int,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (Id_cliente) REFERENCES Cliente(ID),
    FOREIGN KEY (TipoDePago) REFERENCES TipoDePago(ID)
); 
CREATE TABLE Detalle_Factura(
	id_detalle int,
    id_factura int,
    id_pedido int,
    PRIMARY KEY (id_detalle),
    FOREIGN KEY (id_factura) REFERENCES Factura(ID),
    FOREIGN KEY (id_pedido) REFERENCES Pedido(ID)
);