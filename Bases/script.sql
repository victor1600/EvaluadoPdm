CREATE TABLE dueño (
 coddueño VARCHAR(6) NOT NULL PRIMARY KEY,
 nombre VARCHAR(30),
 apellido VARCHAR(30),
 patrimonio FLOAT,
 numequipos INTEGER);
CREATE TABLE pais (
 codpais VARCHAR(3) NOT NULL PRIMARY KEY,
 nompais VARCHAR(30),
 esEuropeo VARCHAR(1));
CREATE TABLE equipo (
 coddueño VARCHAR(6) NOT NULL ,
 codpais VARCHAR(3) NOT NULL ,
 correquipo VARCHAR(2) ,
 taquilla2019 FLOAT ,
 PRIMARY KEY(coddueño,codpais,correquipo)
 CONSTRAINT fk_equipo_pais FOREIGN KEY (codpais) REFERENCES
pais(codpais) ON DELETE RESTRICT,
 CONSTRAINT fk_equipo_dueño FOREIGN KEY (coddueño) REFERENCES dueño(coddueño) ON
DELETE RESTRICT)