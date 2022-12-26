package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cartao;

public class CartaoDAO {
	Connection conex = null;
	
	public List<Cartao> listarCartao(){
		
		List<Cartao> listaCartao = new ArrayList<Cartao>();
		ResultSet rs = null;
		Cartao cartao = null;
		conex = DAO.criarConexao();
		String sql = "SELECT * FROM tb_cartao;";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cartao = new Cartao();
				
				cartao.setId(rs.getInt("id"));
				cartao.setBanco(rs.getString("banco"));
				cartao.getId_conta().setId(rs.getInt("id_conta"));
				
				listaCartao.add(cartao);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCartao;
				
	}
}
