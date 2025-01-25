CREATE TABLE TIPOS(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL
);

CREATE TABLE POKEMONS(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    numeroPokedex INT NOT NULL,
    region VARCHAR(20) NOT NULL,
    tipoId INT,
    tipo2Id INT,
    FOREIGN KEY (tipoId) REFERENCES TIPOS(id),
    FOREIGN KEY (tipo2Id) REFERENCES TIPOS(id)
);

CREATE TABLE ESTADISTICAS(
    pokemonId INT PRIMARY KEY,
    hp INT,
    ataque INT,
    defensa INT,
    ataqueEspecial INT,
    defensaEspecial INT,
    velocidad INT,
    FOREIGN KEY (pokemonId) REFERENCES POKEMONS(id)
);

CREATE TABLE MOVIMIENTOS(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    tipoId INT,
    poder INT,
    categoria VARCHAR(30),
    FOREIGN KEY (tipoId) REFERENCES TIPOS(id)
);

CREATE TABLE POKEMON_MOVIMIENTOS(
    pokemonId INT,
    movimientoId INT,
    nivelAprendizaje INT,
    PRIMARY KEY(pokemonId,movimientoId),
    FOREIGN KEY (pokemonId) REFERENCES POKEMONS(id),
    FOREIGN KEY (movimientoId) REFERENCES MOVIMIENTOS(id)
);

INSERT INTO TIPOS(nombre) VALUES ('Normal'),('Fuego'),('Agua'),('Planta'),('Electrico'),('Hielo'),('Lucha'),('Veneno'),('Tierra'),('Volador'),('Psiquico'),('Bicho'),('Roca'),('Fantasma'),('Siniestro'),('Dragon'),('Acero'),('Hada');

INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Bulbasaur',1,'Kanto',4,8);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Ivysaur',2,'Kanto',4,8);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Venusaur',3,'Kanto',4,8);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Charmander',4,'Kanto',2,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Charmeleon',5,'Kanto',2,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Charizard',6,'Kanto',2,10);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Squirtle',7,'Kanto',3,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Wartortle',8,'Kanto',3,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Blastoise',9,'Kanto',3,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Caterpie',10,'Kanto',12,null);


INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Chikorita',152,'Johto',4,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Bayleef',153,'Johto',4,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Meganium',154,'Johto',4,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Cyndaquil',155,'Johto',2,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Quilava',156,'Johto',2,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Typhlosion',157,'Johto',2,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Totodile',158,'Johto',3,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Croconaw',159,'Johto',3,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Feraligatr',160,'Johto',3,null);
INSERT INTO POKEMONS(nombre,numeroPokedex, region, tipoId, tipo2Id) VALUES ('Pichu',172,'Johto',5,null);


INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (1,45,49,49,65,65,45);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (2,60,62,63,80,80,60);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (3,80,82,84,100,100,80);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (4,39,52,43,60,50,65);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (5,58,64,58,80,65,80);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (6,78,84,78,109,85,100);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (7,35,55,40,50,50,90);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (8,50,65,64,75,50,58);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (9,70,85,80,109,105,78);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (10,45,30,35,20,20,45);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (11,50,65,64,44,50,55);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (12,60,75,75,60,70,80);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (13,80,100,100,83,100,100);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (14,39,52,43,60,50,65);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (15,58,64,58,80,65,80);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (16,78,84,78,109,85,100);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (17,50,65,64,44,48,43);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (18,65,75,70,44,50,83);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (19,85,105,100,79,85,78);
INSERT INTO ESTADISTICAS(pokemonId,hp,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad) VALUES (20,20,40,15,35,35,60);



INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Placaje',1,40,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Ascuas',2,40,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Latigazo',3,45,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Pistola de Agua',4,40,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Rayo',5,90,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Ataque Rapido',1,40,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Rayo Hielo',6,90,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Psiquico',7,90,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Terremoto',9,100,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Vuelo',10,90,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Hiperrayo',1,150,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Sismo',9,50,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Garra Dragón',16,80,'Fisico');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Lanzallamas',2,90,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Surf',4,95,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Bola Sombra',14,80,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Trueno',5,110,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Bomba Lodo',8,90,'Especial');
INSERT INTO MOVIMIENTOS(nombre,tipoId,poder,categoria) VALUES ('Excavar',9,80,'Fisico');



INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (1,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (1,3,5);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (2,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (2,3,9);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (3,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (3,3,15);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (4,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (4,2,9);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (5,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (5,2,13);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (6,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (6,2,12);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (7,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (7,4,9);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (8,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (8,4,14);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (9,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (9,4,12);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (10,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (10,3,9);

INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (11,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (11,3,5);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (12,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (12,3,6);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (13,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (13,3,10);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (14,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (14,2,9);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (15,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (15,2,13);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (16,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (16,2,15);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (17,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (17,4,5);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (18,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (18,4,10);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (19,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (19,4,10);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (20,1,1);
INSERT INTO POKEMON_MOVIMIENTOS (pokemonId, movimientoId, nivelAprendizaje) VALUES (20,5,7);