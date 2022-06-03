CREATE DATABASE IF NOT EXISTS imob;

USE imob;

CREATE TABLE Imovel (
  codigo int NOT NULL,
  endereco  varchar(100) NOT NULL,
  bairo varchar(100) NOT NULL,
  cep char(8) NOT NULL
  PRIMARY KEY (codigo)
);

CREATE TABLE corretor (
  creci CHAR(7) NOT NULL,
  nome  varchar(100) NOT NULL,
  regiao VARCHAR(200) NOT NULL,
  telefone CHAR(15),
  PRIMARY KEY (creci)
);
