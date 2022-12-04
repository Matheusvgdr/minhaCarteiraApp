package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Carteira;

public class CarteiraDAO {
	
	Connection conex = null ;
	
	//Retorna uma carteira baseada id passado por parâmetro
	public Carteira procurarCarteira(int id) {
		
		Carteira cart = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_carteira;";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
			cart = new Carteira();
			
			cart.setId(rs.getInt("id"));
			cart.setNomeCarteria(rs.getString("nomeCarteira"));
			cart.setDinheiro(rs.getDouble("dinheiro"));
			cart.getId_cartao().setId(rs.getInt("id"));
			cart.getId_conta().setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cart;
	}
	
	//Insere uma carteira no bando de dados
	public boolean cadastrarCarteira(Carteira cart) {
		
		boolean resultado = true;
		int retornoQuery;
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_carteira(nomeCarteira, dinheiro, id_conta, id_cartao) VALUES(?, ?, ?, ?);";
		
		PreparedStatement ps;
		
		try {
			
			ps = conex.prepareStatement(sql);
			
			ps.setString(1, cart.getNomeCarteria());
			ps.setDouble(2, cart.getDinheiro());
			ps.setInt(3, cart.getId_conta().getId());
			ps.setInt(4, cart.getId_cartao().getId());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				
				resultado = false;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	//Deleta uma carteira do bando de dados
	public boolean deletarCarteira(int id) {
		
		boolean resultado = true;
		int retornoQuery;
		conex = DAO.criarConexao();
		
		String sql = "DELETE * FROM tb_carteira WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
		}
	
	//Modifica uma carteira do banco de dados
	public boolean modificarCarteira(Carteira cart) {
		
		boolean resultado = true;
		int retornoQuery;
		conex = DAO.criarConexao();
		
		String sql = "UPDATE tb_carteira SET nomeCarteira = ?, dinheiro = ?, id_conta = ?, id_cartao = ?;";
		
		PreparedStatement ps;
		
		try {
			
			ps = conex.prepareStatement(sql);
			
			ps.setString(1, cart.getNomeCarteria());
			ps.setDouble(2, cart.getDinheiro());
			ps.setInt(3, cart.getId_conta().getId());
			ps.setInt(4, cart.getId_cartao().getId());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				
				resultado = false;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return resultado;
	}
}
