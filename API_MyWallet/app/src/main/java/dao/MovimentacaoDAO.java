package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movimentacao;

public class MovimentacaoDAO {
	Connection conex = null;
	
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
				movi.getId_usuario().setId(rs.getInt("id_usuario"));
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
	
	public boolean realizarTransacao(Movimentacao mvt) {
		
		boolean resultado = true;
		int returnQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_movimentacao( dataMovimentacao, dinheiro, id_usuario, id_tipo, id_carteira, id_conta, id_cartao ) VALUES(?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setDate(1, mvt.getDataMovimentacao());
			ps.setDouble(2, mvt.getDinheiro());
			ps.setInt(3, mvt.getId_usuario().getId());
			ps.setInt(4, mvt.getId_tipo().getId());
			ps.setInt(5, mvt.getId_carteira().getId());
			ps.setInt(6, mvt.getId_conta().getId());
			ps.setInt(7, mvt.getId_cartao().getId());
			
			returnQuery = ps.executeUpdate();
			

			if(returnQuery <= 0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}	
		
		return resultado;
	}
	
	/*public boolean verificarSaldo(Movimentacao saldo){
		
		List<Movimentacao> listaDeposito = new ArrayList<Movimentacao>();
		List<Movimentacao> listaSaques = new ArrayList<Movimentacao>();
		
		double saldoDep = 0;
		
		//listaDeposito = this.listarSaques()
	}*/
	
	public List<Movimentacao> listarSaques(int idUser, int idTipo){
		
		List<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		Movimentacao mvt = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT dinheiro FROM tb_movimentacao WHERE id_usuario = ? AND id_tipo = ?;";
		
		PreparedStatement ps;
		try {
			
			ps = conex.prepareStatement(sql);
			ps.setInt(1, idUser);
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
}
