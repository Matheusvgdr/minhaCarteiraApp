CREATE DATABASE db_myWalletUpdt;

use db_myWalletUpdt;

-- TABELAS ----------------------------------------------

CREATE TABLE tb_usuario(
    id int primary key auto_increment,
    nome varchar(250),
    email varchar (250),
 	nomeUsuario varchar(40),
  	senha varchar(20),
    telefone varchar (250),
    nascimento date,
  	cidade varchar(80),
  	estado varchar(80)
);

CREATE TABLE tb_banco(
	id int primary key auto_increment,
  	banco varchar(250),
  	id_usuario int
);

CREATE TABLE tb_carteira(
  	id int primary key auto_increment,
  	nomeCarteira varchar(150),
  	dinheiro double,
  	id_usuario int,
  	id_banco int
);

CREATE TABLE tb_tipoTransacao(
	id int primary key auto_increment,
  	descricao varchar(150)
);

CREATE TABLE tb_movimentacao(
	id int primary key auto_increment,
  	dataMovimentacao date,
  	dinheiro double,
  	id_tipo int,
  	id_carteira int,
  	id_usuario int,
  	id_banco int
);

CREATE TABLE tb_item(
	id int primary key auto_increment,
  	conteudo varchar(150),
  	dinheiro double,
  	id_usuario int, 
  	id_carteira int,
  	id_banco int
);

-- FAZER A CONEXÃO DAS CHAVES ESTRANGEIRAS COM A TB_MOVIMENTACOES -------------------------------------------------------
ALTER TABLE tb_movimentacao ADD CONSTRAINT fk_tipoM FOREIGN KEY(id_tipo) REFERENCES tb_tipoTransacao(id) ON DELETE CASCADE;
ALTER TABLE tb_movimentacao ADD CONSTRAINT fk_usuarioM FOREIGN KEY(id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE;
ALTER TABLE tb_movimentacao ADD CONSTRAINT fk_carteiraM FOREIGN KEY(id_carteira) REFERENCES tb_carteira(id) ON DELETE CASCADE;
ALTER TABLE tb_movimentacao ADD CONSTRAINT fk_bancoM FOREIGN KEY(id_banco) REFERENCES tb_banco(id) ON DELETE CASCADE;


-- FAZER A CONEXÃO DAS CHAVES ESTRANGEIRAS COM A TB_CARTEIRAS -------------------------------------------------------
ALTER TABLE tb_carteira ADD CONSTRAINT fk_usuarioC FOREIGN KEY(id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE;
ALTER TABLE tb_carteira ADD CONSTRAINT fk_cartaoC FOREIGN KEY(id_banco) REFERENCES tb_banco(id) ON DELETE CASCADE;


-- FAZER A CONEXÃO DAS CHAVES ESTRANGEIRAS COM A TB_LISTAS -------------------------------------------------------
ALTER TABLE tb_item ADD CONSTRAINT fk_usuarioI FOREIGN KEY(id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE;
ALTER TABLE tb_item ADD CONSTRAINT fk_carteiraI FOREIGN KEY(id_carteira) REFERENCES tb_carteira(id) ON DELETE CASCADE;
ALTER TABLE tb_item ADD CONSTRAINT fk_bancoI FOREIGN KEY(id_banco) REFERENCES tb_banco(id) ON DELETE CASCADE;


-- FAZER A CONEXÃO DAS CHAVES ESTRANGEIRAS COM A TB_CARTOES -------------------------------------------------------
ALTER TABLE tb_banco ADD CONSTRAINT fk_usuarioCT FOREIGN KEY(id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE;






