--CREATE DATABASE IF NOT EXISTS colegio;

CREATE TABLE PROFESORES(
    codprofesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    asignatura VARCHAR(30)
);
CREATE TABLE ALUMNOS(
    codalumno INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(50),
    notaMedia DECIMAL(4,2)
);

CREATE TABLE PROFESORES_ALUMNOS(
    codprofesor INT,
    codalumno INT,
    aula VARCHAR(20),
    PRIMARY KEY(codprofesor,codalumno),
    FOREIGN KEY (codprofesor) REFERENCES PROFESORES(codprofesor),
    FOREIGN KEY (codalumno) REFERENCES ALUMNOS(codalumno)
);

INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Jorge','Gomez Gonzalez','Matematicas');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Carla','Muñoz Perez','Matematicas');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Juan','Prieto Delgado','Historia');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Marta','Gomez Pinilla','Ingles');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Marcos','Rodriguez Muñoz','Matematicas');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Laura','Vivas Perez','Historia');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Jorge','Arriero Rosales','Ingles');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Martina','Domingo Padilla','Filosofia');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Jose Luis','Pino Gonzalo','Filosofia');
INSERT INTO PROFESORES (nombre,apellidos,asignatura) VALUES ('Angel','Cañizares del Roble','Matematicas');

INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Pedro','Domingo Alonso',7.4);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Raquel','Herrero Pintado',7.1);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Laura','Pardo  Martin',6.5);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Lautaro','De la Fuente Rodriguez',2.2);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Paula','Lopez Rodado',9.8);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Jose','Nogal Camino',6.9);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Julio','Machado Rodrigo',8.0);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Esteban','Alondra Otoño',5.4);
INSERT INTO ALUMNOS (nombre,apellidos,notaMedia) VALUES ('Azucena','Nieves Gonzalez',7.7);

INSERT INTO PROFESORES_ALUMNOS VALUES(1,1,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(1,2,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(1,3,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(1,4,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(3,1,'Aula B15');
INSERT INTO PROFESORES_ALUMNOS VALUES(3,2,'Aula B15');
INSERT INTO PROFESORES_ALUMNOS VALUES(3,3,'Aula B15');
INSERT INTO PROFESORES_ALUMNOS VALUES(4,1,'Aula A01');
INSERT INTO PROFESORES_ALUMNOS VALUES(4,5,'Aula A01');
INSERT INTO PROFESORES_ALUMNOS VALUES(4,5,'Aula A01');
INSERT INTO PROFESORES_ALUMNOS VALUES(5,6,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(5,7,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(5,8,'Aula B14');
INSERT INTO PROFESORES_ALUMNOS VALUES(7,1,'Taller C03');
INSERT INTO PROFESORES_ALUMNOS VALUES(7,4,'Taller C03');
INSERT INTO PROFESORES_ALUMNOS VALUES(7,5,'Taller C03');
INSERT INTO PROFESORES_ALUMNOS VALUES(7,6,'Taller C03');
