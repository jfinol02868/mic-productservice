CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO usuarios (nombre, email) VALUES ('Juan', 'juan@example.com');
INSERT INTO usuarios (nombre, email) VALUES ('María', 'maria@example.com');
