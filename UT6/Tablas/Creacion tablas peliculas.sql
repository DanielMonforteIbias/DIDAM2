--Usuario root, sin contraseña
CREATE DATABASE IF NOT EXISTS peliculas;

USE peliculas;

CREATE TABLE CINES(
    idCine INT AUTO_INCREMENT PRIMARY KEY,
    nombreCine VARCHAR(40) UNIQUE NOT NULL,
    direccionCine VARCHAR(100)
);
CREATE TABLE GENEROS(
    idGenero INT AUTO_INCREMENT PRIMARY KEY,
    nombreGenero VARCHAR(30) UNIQUE NOT NULL
);
CREATE TABLE PELICULAS(
    idPelicula INT AUTO_INCREMENT PRIMARY KEY,
    nombrePelicula VARCHAR(60) UNIQUE NOT NULL,
    idGenero INT,
    visto BOOLEAN NOT NULL DEFAULT FALSE,
    idCine INT,
    calificacion INT DEFAULT 0,
    FOREIGN KEY (idGenero) REFERENCES GENEROS(idGenero),
    FOREIGN KEY (idCine) REFERENCES CINES(idCine)
);


INSERT INTO CINES (nombreCine, direccionCine) VALUES ('Cines Artesiete Los Alfares','N-Va, 45600 Talavera de la Reina, Toledo');
INSERT INTO CINES (nombreCine, direccionCine) VALUES ('Cine Yelmo Isla Azul','C. de la Calderilla, 1, Carabanchel, 28054 Madrid');
INSERT INTO CINES (nombreCine, direccionCine) VALUES ('Cine Yelmo La Vaguada','C. de Santiago de Compostela, S/N, Fuencarral-El Pardo, 28029 Madrid');
INSERT INTO CINES (nombreCine, direccionCine) VALUES ('Cines Cristal','Calle, Rúa Montero Ríos, 25, 27002 Lugo');
INSERT INTO CINES (nombreCine, direccionCine) VALUES ('Cinesa La Cañada','C. Ojén, s/n, 29600 Marbella, Málaga');

INSERT INTO GENEROS (nombreGenero) VALUES 
('Acción'), ('Animación'), ('Aventura'), ('Bélico'), ('Biografía'), ('Ciencia Ficción'),
('Cine Negro'), ('Comedia'), ('Crimen'), ('Deporte'), ('Documental'), ('Drama'),
('Espionaje'), ('Familiar'), ('Fantasía'), ('Histórico'), ('Infantil'), ('Intriga'),
('Musical'), ('Misterio'), ('Noir'), ('Policíaco'), ('Psicológico'), ('Reality'),
('Road Movie'), ('Romance'), ('Slasher'), ('Superhéroes'), ('Suspense'),
('Terror'), ('Thriller'), ('Western'), ('Otro');


INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('Matrix', 6, FALSE, 1);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('Titanic', 26, FALSE, 1);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('El Padrino', 9, FALSE, 2);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('Interestelar', 6, FALSE, 2);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('El Exorcista', 30, FALSE, 1);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('Avengers: Endgame', 1, FALSE, 3);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('El conjuro', 30, FALSE, 4);
INSERT INTO PELICULAS (nombrePelicula, idGenero, visto, idCine) VALUES ('Spider-Man: No Way Home', 1, FALSE, 5);