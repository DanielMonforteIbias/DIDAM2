--CREATE DATABASE IF NOT EXISTS pokemondb2

CREATE TABLE POKEMON(
    pokemonId INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    altura DECIMAL(5,2) NOT NULL,
    peso DECIMAL(5,2) NOT NULL
);

CREATE TABLE MOVIMIENTOS(
    movimientoId INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    poder INT,
    precisionMovimiento DECIMAL(5,2)
);

CREATE TABLE POKEMON_MOVIMIENTO(
    pokemonId INT,
    movimientoId INT,
    nivelAprendido INT,
    PRIMARY KEY (pokemonId,movimientoId),
    FOREIGN KEY (pokemonId) REFERENCES POKEMON(pokemonId),
    FOREIGN KEY (movimientoId) REFERENCES MOVIMIENTOS(movimientoId)
);

INSERT INTO POKEMON (nombre,tipo,altura,peso) VALUES ('Charmander','Fuego',0.6,8.5);
INSERT INTO POKEMON (nombre,tipo,altura,peso) VALUES ('Squirtle','Agua',0.5,9.0);
INSERT INTO POKEMON (nombre,tipo,altura,peso) VALUES ('Bulbasaur','Planta',0.7,6.9);


INSERT INTO MOVIMIENTOS(nombre,tipo,poder,precisionMovimiento) VALUES ('Llamarada','Fuego',110,85);
INSERT INTO MOVIMIENTOS(nombre,tipo,poder,precisionMovimiento) VALUES ('Hidrobomba','Agua',110,80);
INSERT INTO MOVIMIENTOS(nombre,tipo,poder,precisionMovimiento) VALUES ('Hoja Afilada','Planta',90,95);
INSERT INTO MOVIMIENTOS(nombre,tipo,poder,precisionMovimiento) VALUES ('Ataque Rapido','Normal',40,100);


INSERT INTO POKEMON_MOVIMIENTO(pokemonId,movimientoId,nivelAprendido) VALUES (1,1,36);
INSERT INTO POKEMON_MOVIMIENTO(pokemonId,movimientoId,nivelAprendido) VALUES (2,2,36);
INSERT INTO POKEMON_MOVIMIENTO(pokemonId,movimientoId,nivelAprendido) VALUES (3,3,32);
INSERT INTO POKEMON_MOVIMIENTO(pokemonId,movimientoId,nivelAprendido) VALUES (1,4,15);
INSERT INTO POKEMON_MOVIMIENTO(pokemonId,movimientoId,nivelAprendido) VALUES (2,4,10);