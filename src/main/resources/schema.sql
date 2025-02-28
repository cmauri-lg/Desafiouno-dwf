--
-- Tablas de la base de datos: `desafio_jpa`
--

-- ----------------------------------------------------------------
--  TABLE MATERIA
-- ----------------------------------------------------------------
CREATE TABLE MATERIA (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(1000) NOT NULL
);

-- ----------------------------------------------------------------
--  TABLE ALUMNO
-- ----------------------------------------------------------------
CREATE TABLE ALUMNO (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(1000) NOT NULL,
    APELLIDO VARCHAR(1000) NOT NULL,
    ID_MATERIA INT,
    FOREIGN KEY (ID_MATERIA)
        REFERENCES MATERIA(ID) ON DELETE SET NULL
);