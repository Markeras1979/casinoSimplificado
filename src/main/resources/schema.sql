DROP TABLE casino IF EXISTS;
DROP TABLE proveedor IF EXISTS;
DROP TABLE juego IF EXISTS;
DROP TABLE casino_juego IF EXISTS;
DROP TABLE jugador IF EXISTS;
DROP TABLE jugada IF EXISTS;

CREATE TABLE casino  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
);

CREATE TABLE proveedor  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
);

CREATE TABLE juego  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    nombre VARCHAR(20),
    premio_probabilidad VARCHAR(3),
    apuesta_min BIGINT,
    apuesta_max BIGINT
);

CREATE TABLE casino_juego  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    casino_id BIGINT,
    juego_id BIGINT,
    FOREIGN KEY (casino_id) REFERENCES casino(id),
    FOREIGN KEY (juego_id) REFERENCES juego(id)
);

CREATE TABLE jugador  (
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    alias VARCHAR(30),
    tiempo_juego BIGINT,
    credito BIGINT,
    proveedor_id BIGINT,
    FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);

CREATE TABLE jugada  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    jugador_id VARCHAR(50),
    resultado VARCHAR(8),
    apuesta BIGINT,
    FOREIGN KEY (jugador_id) REFERENCES jugador(id)
);

