INSERT INTO tb_usuario(nome, email, nomeUsuario, senha, telefone, nascimento, cidade, estado) 

VALUES("Matheus", "matheus@gmail.com","maths", "12345", "(21)97536-2567", "2001-06-06", "são gonçalo", "rio de janeiro");

INSERT INTO tb_banco(banco, id_usuario) VALUES("Nubank", 1);
INSERT INTO tb_banco(banco, id_usuario) VALUES("Caixa", 1);
INSERT INTO tb_banco(banco, id_usuario) VALUES("Itaú", 1);
INSERT INTO tb_banco(banco, id_usuario) VALUES("Bradesco", 1);
INSERT INTO tb_banco(banco, id_usuario) VALUES("Santander", 1);
INSERT INTO tb_banco(banco, id_usuario) VALUES("Banco do Brasil", 1);
INSERT INTO tb_banco(banco, id_usuario) VALUES("Nenhum", 1);

INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_usuario, id_banco) VALUES("casa", 150, 1, 1);
INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_usuario, id_banco) VALUES("cinema", 120, 1, 1);
INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_usuario, id_banco) VALUES("passagem", 342, 1, 1);
INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_usuario, id_banco) VALUES("viagem", 1300, 1, 1);

INSERT INTO tb_tipoTransacao(descricao) VALUES("Depósito");
INSERT INTO tb_tipoTransacao(descricao) VALUES("Saque");

INSERT INTO tb_movimentacao(dataMovimentacao, dinheiro, id_tipo, id_carteira, id_usuario, id_banco) VALUES("2022-12-01", 250, 1, 1, 1, 1);

INSERT INTO tb_movimentacao(dataMovimentacao, dinheiro, id_tipo, id_carteira, id_usuario, id_banco) VALUES("2022-12-01", 150, 2, 1, 1, 1);

INSERT INTO tb_item(conteudo, dinheiro, id_usuario, id_carteira, id_banco) VALUES("batata", 10, 1, 1, 1);







