package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Banco;
import model.Movimentacao;
import model.TipoTransacao;
import model.Usuario;

public class MovimentacaoDAO {
	Connection conex = null;
	//Teste da branch matheus
	//Testar o push da nova branch
	
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
				movi.getId_usuario().setId(rs.getInt("id_usuario"));
				movi.getId_banco().setId(rs.getInt("id_banco"));
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
		
		String sql = "INSERT INTO tb_movimentacao( dataMovimentacao, dinheiro, id_tipo, id_carteira, id_usuario, id_banco ) VALUES(?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setDate(1, mvt.getDataMovimentacao());
			ps.setDouble(2, mvt.getDinheiro());
			ps.setInt(3, mvt.getId_tipo().getId());
			ps.setInt(4, mvt.getId_carteira().getId());
			ps.setInt(5, mvt.getId_usuario().getId());
			ps.setInt(6, mvt.getId_banco().getId());
			
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
		
		listaDeposito = this.listarDepositos(saldo.getId_usuario().getId(), 1);
		
		for(Movimentacao mov: listaDeposito) {
			
			saldoDeposito += mov.getDinheiro();
		}
		
		double saldoSaque = 0;
		
		listaSaques = this.listarSaques(saldo.getId_usuario().getId(), 2);
		
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
	public List<Movimentacao> listarTransacoes(int idUsuario){
		
		List<Movimentacao> listaDeTransacoes = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		Movimentacao mvt = null;
		TipoTransacao tipo = null;
		Usuario usu = null;
		Banco banco = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT U.nomeUsuario, M.dataMovimentacao, M.dinheiro, T.descricao, U.nome, C.banco FROM tb_movimentacao M INNER JOIN tb_usuario U ON U.id = M.id_usuario \r\n"
				+ "																								  INNER JOIN tb_tipoTransacao T ON T.id = M.id_tipo \r\n"
				+ "                                                                                               INNER JOIN tb_banco C ON C.id = M.id_banco\r\n"
				+ "																								  WHERE M.id_usuario = ?;";
		
		
		try {
			
			PreparedStatement ps;
			
			ps = conex.prepareStatement(sql);
			
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				tipo = new TipoTransacao();
				mvt = new Movimentacao();
				usu = new Usuario();
				banco = new Banco();
				
				mvt.setId_usuario(usu);
				mvt.setId_tipo(tipo);
				mvt.setId_banco(banco);
				
				mvt.setDinheiro(rs.getDouble("dinheiro"));
				mvt.setDataMovimentacao(rs.getDate("dataMovimentacao"));
				mvt.getId_usuario().setNomeUsuario(rs.getString("nomeUsuario"));
				mvt.getId_tipo().setDescricao(rs.getString("descricao"));
				mvt.getId_usuario().setNome(rs.getString("nome"));
				mvt.getId_banco().setBanco(rs.getString("banco"));
				
				listaDeTransacoes.add(mvt);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listaDeTransacoes;
		
	}
	
	//Insere uma transação realizada para uma carteira, que pertence a um usuário
	public boolean realizarTransacaoCarteira(Movimentacao mvt){
		
		//USAR SELECT COM INNER JOIN
		boolean resultado = true;
		int retornoQueryMovi, retornoQueryCarte;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_movimentacao( dataMovimentacao, dinheiro, id_tipo, id_carteira, id_usuario, id_banco ) VALUES(?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setDate(1, mvt.getDataMovimentacao());
			ps.setDouble(2, mvt.getDinheiro());
			ps.setInt(3, mvt.getId_tipo().getId());
			ps.setInt(4, mvt.getId_carteira().getId());
			ps.setInt(5, mvt.getId_usuario().getId());
			ps.setInt(6, mvt.getId_banco().getId());
			
			retornoQueryMovi = ps.executeUpdate();
		
		String sqlCarteira = "INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_usuario, id_banco) VALUES(?, ?, ?, ?)";
		
			ps = conex.prepareStatement(sqlCarteira);
			
			ps.setString(1, mvt.getId_carteira().getNomeCarteira());
			ps.setDouble(2, mvt.getDinheiro());
			ps.setInt(3, mvt.getId_usuario().getId());
			ps.setInt(4, mvt.getId_banco().getId());
			
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
