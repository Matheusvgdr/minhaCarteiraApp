package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carteira;
import model.Conta;
import model.Movimentacao;
import model.TipoTransacao;
import model.Usuario;

public class MovimentacaoDAO {
	Connection conex = null;
	
	//Encontra as movimentações relativas a determinado usuario
	public Movimentacao procurarPorId(int id) {
		
		Movimentacao movi = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_movimentacao WHERE id = ?";
		
		try {
			
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				movi = new Movimentacao();
				
				movi.setId(rs.getInt("id"));
				movi.setDataMovimentacao(rs.getDate("dataMovimentacao"));
				movi.setDinheiro(rs.getDouble("dinheiro"));
				movi.getId_tipo().setId(rs.getInt("id_tipo"));
				movi.getId_carteira().setId(rs.getInt("id_carteira"));
				movi.getId_conta().setId(rs.getInt("id_conta"));
				movi.getId_cartao().setId(rs.getInt("id_cartao"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return movi;
		
	}
	
	//Insere uma transação no banco de dados
	public boolean realizarTransacao(Movimentacao mvt) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_movimentacao( dataMovimentacao, dinheiro, id_tipo, id_carteira, id_conta, id_cartao ) VALUES(?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setDate(1, mvt.getDataMovimentacao());
			ps.setDouble(2, mvt.getDinheiro());
			ps.setInt(3, mvt.getId_tipo().getId());
			ps.setInt(4, mvt.getId_carteira().getId());
			ps.setInt(5, mvt.getId_conta().getId());
			ps.setInt(6, mvt.getId_cartao().getId());
			
			retornoQuery = ps.executeUpdate();
			

			if(retornoQuery <= 0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}	
		
		return resultado;
	}
	
	//Faz o calculo para determinar o saldo final do usuario
	public boolean verificarSaldo(Movimentacao saldo){
		
		List<Movimentacao> listaDeposito = new ArrayList<Movimentacao>();
		List<Movimentacao> listaSaques = new ArrayList<Movimentacao>();
		
		double saldoDeposito = 0;
		
		listaDeposito = this.listarDepositos(saldo.getId_conta().getId_usuario().getId(), saldo.getId_tipo().getId());
		
		for(Movimentacao mov: listaDeposito) {
			
			saldoDeposito += mov.getDinheiro();
		}
		
		double saldoSaque = 0;
		
		listaSaques = this.listarSaques(saldo.getId_conta().getId_usuario().getId(), saldo.getId_tipo().getId());
		
		for(Movimentacao mov: listaSaques) {
			saldoSaque += mov.getDinheiro();
		}
		
		double saldoFinal = saldoDeposito - saldoSaque;
		
		if(saldo.getDinheiro() > saldoFinal && saldo.getId_tipo().getId() == 2) {
			
			return false;
			
		}else {
			
			return true;
			
		}
	}
	
	//Lista todos os saques feitos por um determinado usuario
	public List<Movimentacao> listarSaques(int idConta, int idTipo){
		
		List<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		Movimentacao mvt = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT dinheiro FROM tb_movimentacao WHERE id_usuario = ? AND id_tipo = ?;";
		
		PreparedStatement ps;
		try {
			
			ps = conex.prepareStatement(sql);
			ps.setInt(1, idConta);
			ps.setInt(2, idTipo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				mvt = new Movimentacao();
				
				mvt.setDinheiro(rs.getDouble("dinheiro"));
				
				listaDeSaques.add(mvt);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listaDeSaques;
	}
	
	//Lista todos os depósitos feitos por um determinado usuario
	public List<Movimentacao> listarDepositos(int idConta, int idTipo){
		List<Movimentacao> listaDeDepositos = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		Movimentacao mvt = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT dinheiro FROM tb_movimentacao WHERE id_usuario = ? AND id_tipo = ?;";
		
		PreparedStatement ps;
		
		try {
			
			ps = conex.prepareStatement(sql);
			ps.setInt(1, idConta);
			ps.setInt(2, idTipo);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				mvt = new Movimentacao();
				
				mvt.setDinheiro(rs.getDouble("dinheiro"));
				
				listaDeDepositos.add(mvt);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listaDeDepositos;
		
	}
	
	//Lista todas as transações feitas por um determinado usuário
	public List<Movimentacao> listarTransacoes(int idConta){
		
		List<Movimentacao> listaDeTransacoes = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		Movimentacao mvt = null;
		Conta conta = null;
		TipoTransacao tipo = null;
		Usuario usu = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT C.nomeUsuario, M.dataMovimentacao, M.dinheiro, T.descricao, U.nome, U.email  FROM tb_movimentacao M INNER JOIN tb_conta C ON C.id = M.id_conta \r\n"
				+ "																								  INNER JOIN tb_tipostransacao T ON T.id = M.id_tipo  \r\n"
				+ "                                                                                                  INNER JOIN tb_usuario U ON U.id = C.id_usuario\r\n"
				+ "																								  WHERE id_conta = ?";
		
		
		try {
			
			PreparedStatement ps;
			
			ps = conex.prepareStatement(sql);
			
			ps.setInt(1, idConta);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				conta = new Conta();
				tipo = new TipoTransacao();
				mvt = new Movimentacao();
				usu = new Usuario();
				
				mvt.setId_conta(conta);
				mvt.setId_tipo(tipo);
				mvt.getId_conta().setId_usuario(usu);;
				
				mvt.setDinheiro(rs.getDouble("dinheiro"));
				mvt.setDataMovimentacao(rs.getDate("dataMovimentacao"));
				mvt.getId_conta().setNomeUsuario(rs.getString("nomeUsuario"));
				mvt.getId_tipo().setDescricao(rs.getString("descricao"));
				mvt.getId_conta().getId_usuario().setNome(rs.getString("nome"));
				mvt.getId_conta().getId_usuario().setEmail(rs.getString("email"));
				
				listaDeTransacoes.add(mvt);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listaDeTransacoes;
		
	}
	
	//Insere uma transação realizada para uma carteira, que pertence a um usuário
	public boolean realizarTransacaoCarteira(Movimentacao mvt){
		
		boolean resultado = true;
		int retornoQueryMovi, retornoQueryCarte;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_movimentacao( dataMovimentacao, dinheiro, id_tipo, id_carteira, id_conta, id_cartao ) VALUES(?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setDate(1, mvt.getDataMovimentacao());
			ps.setDouble(2, mvt.getDinheiro());
			ps.setInt(3, mvt.getId_tipo().getId());
			ps.setInt(4, mvt.getId_carteira().getId());
			ps.setInt(5, mvt.getId_conta().getId());
			ps.setInt(6, mvt.getId_cartao().getId());
			
			retornoQueryMovi = ps.executeUpdate();
		
		String sqlCarteira = "INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_conta, id_cartao) VALUES(?, ?, ?, ?)";
		
			ps = conex.prepareStatement(sqlCarteira);
			
			ps.setString(1, mvt.getId_carteira().getNomeCarteria());
			ps.setDouble(2, mvt.getId_carteira().getDinheiro());
			ps.setInt(3, mvt.getId_carteira().getId_conta().getId());
			ps.setInt(4, mvt.getId_carteira().getId_cartao().getId());
			
			retornoQueryCarte = ps.executeUpdate();
			
			if(retornoQueryMovi <= 0 && retornoQueryCarte <= 0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return resultado;
		
	}
}
