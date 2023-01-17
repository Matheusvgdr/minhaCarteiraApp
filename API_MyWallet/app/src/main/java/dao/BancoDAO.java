package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Banco;

public class BancoDAO {
	Connection conex = null;
	
	public List<Banco> listarBancos(){
		
		List<Banco> listaCartao = new ArrayList<Banco>();
		ResultSet rs = null;
		Banco cartao = null;
		conex = DAO.criarConexao();
		String sql = "SELECT * FROM tb_banco;";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cartao = new Banco();
				
				cartao.setId(rs.getInt("id"));
				cartao.setBanco(rs.getString("banco"));
				//cartao.getId_usuario().setId(rs.getInt("id_usuario"));
				
				listaCartao.add(cartao);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCartao;
				
	}
}
