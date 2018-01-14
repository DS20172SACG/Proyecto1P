drop database if exists SARES;

create database if not exists SARES;

use SARES;

create table Usuario(
	usuario varchar(50) not null,
    clave varchar(50) not null,
    primary key (usuario)
);

create table Cargo(
	idCargo int not null auto_increment,
    nombreCargo varchar(50) not null,
    eliminado boolean not null,
    primary key (idCargo)
);

create table Personal(
	cedula varchar(10) not null,
    nombres varchar(255) not null,
    apellidos varchar(255) not null,
    edad int not null,
    sueldo float not null,
    idCargo int not null auto_increment,
    usuario varchar(50) not null,
    eliminado boolean not null,
    primary key (cedula),
    foreign key (usuario) references Usuario(usuario),
    foreign key (idCargo) references Cargo(idCargo)
);

create table Ambientes(
	idAmbiente int not null auto_increment,
    nombre varchar(255) not null,
    eliminado boolean not null,
    primary key (idAmbiente)
);

create table Mesa(
	idMesa int not null auto_increment,
    asientos int not null,
    disponibilidad boolean not null,
    idAmbiente int not null,
    eliminado boolean not null,
    Primary Key (idMesa),
    foreign key (idAmbiente) references Ambientes(idAmbiente)
);

CREATE TABLE Cliente (
	Cedula varchar(10) not null,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Direccion varchar(255),
    eliminado boolean not null,
    PRIMARY KEY (Cedula)
);

CREATE TABLE Categoria_Articulo(
	ID int NOT NULL,
    Nombre VARCHAR(255),
    Descripcion VARCHAR(255),
    
    PRIMARY KEY(ID)
);

CREATE TABLE Articulo(

	ID int NOT NULL auto_increment,
    Nombre VARCHAR(255),
    Descripcion VARCHAR(255),
    
    Precio DOUBLE not null,
    Disponibilidad boolean not null,
	TiempoPreparacion int not null,
    Idcategoria int not null,
    eliminado boolean not null,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (Idcategoria) references Categoria_Articulo(ID)
);

create table Pedido (
	id int not null auto_increment,
    pagado boolean not null,
    enPreparacion boolean not null,
    cocinado boolean not null,
    entregado boolean not null,
    idCliente varchar(10) not null,
    idMesero varchar(10) not null,
    idCocinero varchar(10),
    primary key (id),
    foreign key (idCliente) references Cliente(Cedula),
    foreign key (idMesero) references Personal(cedula),
    foreign key (idCocinero) references Personal(cedula)
);

CREATE TABLE Detalle_Pedido(

	ID_detalle int NOT NULL auto_increment,
    ID_Pedido int NOT NULL,
    ID_Articulo int NOT NULL,
    cantidad int,
    Observaciones varchar(255),
    
    
    PRIMARY KEY (ID_detalle),
    FOREIGN KEY (ID_Pedido) references Pedido(id),
    foreign key (ID_Articulo) references Articulo(ID)
);

create table MesaPedido(
	id int not null auto_increment,
    idMesa int not null,
    idPedido int not null,
    fecha Date,
    hora time,
    
    primary key (id),
    foreign key (idMesa) references Mesa(idMesa),
    foreign key (idPedido) references Pedido(id)
);

CREATE TABLE TipoDePago(
	ID int,
    Tipo varchar(30),
    
    PRIMARY KEY (ID)
);

CREATE TABLE Factura (
    ID int NOT NULL auto_increment,
    TOTAL double,
    Fecha DATE,
    Id_cliente varchar(10) not null,
    Descuento int,
    TipoDePago int,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (Id_cliente) REFERENCES Cliente(cedula),
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