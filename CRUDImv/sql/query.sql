CREATE DATABASE IF NOT EXISTS imob;

USE imob;

CREATE TABLE Imovel (
  codigo int NOT NULL,
  endereco  varchar(100) NOT NULL,
  PRIMARY KEY (codigo)
);