--CREATE DATABASE IF NOT EXISTS PokemonDB;

CREATE TABLE POKEMON(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo1 VARCHAR(20) NOT NULL,
    tipo2 VARCHAR(20),
    hp INT NOT NULL,
    ataque INT NOT NULL,
    defensa INT NOT NULL,
    velocidad INT NOT NULL,
    region VARCHAR(30)
);

INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Pikachu','Electrico',null,35,55,40,90,'Kanto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Charmander','Fuego',null,39,52,43,65,'Kanto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Bulbasaur','Planta','Veneno',45,49,49,45,'Kanto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Squirtle','Agua',null,44,48,65,43,'Kanto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Gengar','Fantasma','Veneno',60,65,60,110,'Kanto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Umbreon','Psiquico',null,65,65,60,110,'Johto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Scizor','Bicho','Acero',70,130,100,65,'Johto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Tyranitar','Roca','Siniestro',100,134,110,61,'Johto');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Blaziken','Fuego','Lucha',80,120,70,80,'Hoenn');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Flygon','Tierra','Dragon',80,100,80,100,'Hoenn');
INSERT INTO POKEMON (nombre,tipo1,tipo2,hp,ataque,defensa,velocidad,region) VALUES ('Metagross','Acero','Psiquico',80,135,130,70,'Hoenn');