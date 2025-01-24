--CREATE DATABASE IF NOT EXISTS supermercado
--Crear la base de datos, su conexion, y en dicha conexion las siguientes tablas

CREATE TABLE CATEGORIAS(
    codigo int AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE
);

CREATE TABLE PROVEEDORES(
    nit VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE,
    telefono VARCHAR(9),
    direccion VARCHAR(100),
    correo VARCHAR(50)
);

CREATE TABLE PRODUCTOS(
    codigo int PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100),
    cantidad int,
    precio float,
    codigo_categoria int,
    nit_proveedor VARCHAR(20),
    FOREIGN KEY (codigo_categoria) REFERENCES CATEGORIAS(codigo),
    FOREIGN KEY (nit_proveedor) REFERENCES PROVEEDORES(nit)
);