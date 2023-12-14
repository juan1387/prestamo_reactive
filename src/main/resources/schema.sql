CREATE TABLE cliente(
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    tipo_doc VARCHAR(255),
    nun_doc VARCHAR(255),
    id INT AUTO_INCREMENT PRIMARY KEY

);

CREATE TABLE cartera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    clienteid INT,
    dinero_prestado BIGINT,
    fecha_entrega DATE,
    fecha_devolucion DATE,
    tasa_prestamo FLOAT,
    estado VARCHAR(255),
    FOREIGN KEY (clienteid) REFERENCES Cliente(id)
);


CREATE TABLE tasas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tasa VARCHAR(255),
    valor_tasa DOUBLE,
    descripcion VARCHAR(255)
);

INSERT INTO tasas(nombre_tasa,valor_tasa,descripcion) VALUES
('tasa_normal', 0.2, 'esta tasa es la tasa normal para creditos'),
('tasa_preferencial', 0.1,'esta tasa es la tasa preferencial para creditos'),
('tasa_fullpreferencial', 0.05,'esta tasa es la tasa preferencial para creditos');

CREATE TABLE Fondos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ingreso BIGINT,
    fecha_ingreso DATE,
    descripcion VARCHAR(255)
);