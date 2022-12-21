package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lista;

public class ListaDAO {
	Connection conex = null;
	
	public Lista procurarItem(int idItem) {
		Lista item = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_lista WHERE id = ?;";
		
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);
			ps.setInt(1, idItem);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Lista();
				
				item.setId(rs.getInt(("id")));
				item.setConteudo(rs.getString("conteudo"));
				item.setDinheiro(rs.getDouble("dinheiro"));
				item.getId_cartao().setId(rs.getInt("id_cartao"));
				item.getId_conta().setId(rs.getInt("id_conta"));
				item.getId_carteira().setId(rs.getInt("id_carteira"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	
	}
	
	public boolean cadastrarItem(Lista item) {
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_lista(conteudo, dinheiro, id_cartao, id_conta, id_carteira) VALUES(?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, item.getConteudo());
			ps.setDouble(2, item.getDinheiro());
			ps.setInt(3, item.getId_cartao().getId());
			ps.setInt(4, item.getId_conta().getId());
			ps.setInt(5, item.getId_carteira().getId());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				resultado = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public boolean deletarItem(int idItem) {
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "DELETE FROM tb_lista WHERE id = ?;";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			ps.setInt(1, idItem);
			
			retornoQuery = ps.executeUpdate();
			
			if (retornoQuery <= 0) {
				resultado = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public boolean modificarItem(Lista item) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "UPDATE tb_lista SET conteudo = ?, dinheiro = ? WHERE id = ?;";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, item.getConteudo());
			ps.setDouble(2, item.getDinheiro());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				resultado = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	public List<Lista> listarItens(int idConta){
		
		List<Lista> listaDeItens = new ArrayList<Lista>();
		ResultSet rs = null;
		Lista lista = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_lista WHERE id_conta = ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setInt(1, idConta);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				lista = new Lista();
				
				lista.setId(rs.getInt("id"));
				lista.setConteudo(rs.getString("conteudo"));
				lista.setDinheiro(rs.getDouble("dinheiro"));
				lista.getId_cartao().setId(rs.getInt("id_cartao"));
				lista.getId_conta().setId(rs.getInt("id_conta"));
				lista.getId_carteira().setId(rs.getInt("id_carteira"));
				
				listaDeItens.add(lista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeItens;
	}
}
