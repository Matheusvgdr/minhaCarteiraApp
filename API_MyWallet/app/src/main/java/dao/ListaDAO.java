package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ListaDAO {
	Connection conex = null;
	
	public Item procurarItem(int idItem) {
		Item item = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_item WHERE id = ?;";
		
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);
			ps.setInt(1, idItem);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Item();
				
				item.setId(rs.getInt(("id")));
				item.setConteudo(rs.getString("conteudo"));
				item.setDinheiro(rs.getDouble("dinheiro"));
				item.getId_banco().setId(rs.getInt("id_banco"));
				item.getId_usuario().setId(rs.getInt("id_usuario"));
				item.getId_carteira().setId(rs.getInt("id_carteira"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	
	}
	
	public boolean cadastrarItem(Item item) {
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_item(conteudo, dinheiro, id_banco, id_usuario, id_carteira) VALUES(?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, item.getConteudo());
			ps.setDouble(2, item.getDinheiro());
			ps.setInt(3, item.getId_banco().getId());
			ps.setInt(4, item.getId_usuario().getId());
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
		
		String sql = "DELETE FROM tb_item WHERE id = ?;";
		
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
	
	public boolean modificarItem(Item item) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "UPDATE tb_item SET conteudo = ?, dinheiro = ? WHERE id = ?;";
		
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

	public List<Item> listarItens(int idConta){
		
		List<Item> listaDeItens = new ArrayList<Item>();
		ResultSet rs = null;
		Item lista = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_item WHERE id_usuario = ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setInt(1, idConta);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				lista = new Item();
				
				lista.setId(rs.getInt("id"));
				lista.setConteudo(rs.getString("conteudo"));
				lista.setDinheiro(rs.getDouble("dinheiro"));
				lista.getId_banco().setId(rs.getInt("id_banco"));
				lista.getId_usuario().setId(rs.getInt("id_usuario"));
				lista.getId_carteira().setId(rs.getInt("id_carteira"));
				
				listaDeItens.add(lista);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeItens;
	}
}
