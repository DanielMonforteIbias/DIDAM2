--CREATE DATABASE IF NOT EXISTS colegio;

CREATE TABLE PROFESORES(
    codprofesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    asignatura VARCHAR(30)
);

INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Jorge','Gomez Gonzalez','Matematicas');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Carla','Muñoz Perez','Matematicas');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Juan','Prieto Delgado','Historia');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Marta','Gomez Pinilla','Ingles');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Marcos','Rodriguez Muñoz','Matematicas');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Laura','Vivas Perez','Historia');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Jorge','Arriero Rosales','Ingles');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Martina','Domingo Padilla','Filosofia');