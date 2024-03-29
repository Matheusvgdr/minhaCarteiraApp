package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carteira;

public class CarteiraDAO {
	Connection conex = null;

public Carteira procurarCarteira(int id){
	
	Carteira car = null;
	ResultSet rs = null;
	conex = DAO.criarConexao();
	
	String sql = "SELECT * FROM tb_carteira WHERE id = ?";
	
	try {
		PreparedStatement ps = conex.prepareStatement(sql);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
			while (rs.next()) {
				car = new Carteira();
				
				car.setId(rs.getInt("id"));
				car.setDinheiro(rs.getDouble("dinheiro"));
				car.setNomeCarteira(rs.getString("nomeCarteira"));
			}
		
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return car;
}

public boolean cadastrarCarteira(Carteira cdt) {
	
	boolean resultado = true;
	int retornoQuery;
	
	conex = DAO.criarConexao();
	
	String sql = "INSERT INTO tb_carteira( nomeCarteira, dinheiro, id_banco, id_usuario) VALUES(?, ?, ?, ?);";
	
	PreparedStatement ps;
	try {
		ps = conex.prepareStatement(sql);
		
		ps.setString(1, cdt.getNomeCarteira());
		ps.setDouble(2, cdt.getDinheiro());
		ps.setInt(3, cdt.getId_banco().getId());
		ps.setInt(4, cdt.getId_usuario().getId());
		
		retornoQuery = ps.executeUpdate();
		
		if(retornoQuery <= 0) {
			resultado = false;
		}
		
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return resultado;
}

public boolean deletarCarteira(int id) {
	
	boolean resultado = true;
	int retornoQuery;
	
	conex = DAO.criarConexao();
	
	String sql = "DELETE FROM tb_carteira WHERE id = ?;";
	
	try {
		
		PreparedStatement ps = conex.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		retornoQuery = ps.executeUpdate();
		
		if (retornoQuery <= 0) {
			resultado = false;
		}
		
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return resultado;
	
}

public boolean modificarCarteira(Carteira md) {
	
	boolean resultado = true;
	int retornoQuery;
	
	conex = DAO.criarConexao();
	
	String sql = "UPDATE tb_carteira SET nomeCarteira = ? WHERE id = ?;";
	
	try {
		
		PreparedStatement ps = conex.prepareStatement(sql);
		
		ps.setString(1, md.getNomeCarteira());
		ps.setInt(2, md.getId());
		
		retornoQuery = ps.executeUpdate();
		
		if(retornoQuery <= 0) {
			resultado = false;
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return resultado;
}

public List<Carteira> listarCarteira(int idUsuario){
	
	List<Carteira> listaDeCarteira = new ArrayList<Carteira>();
	ResultSet rs = null;
	Carteira car = null;
	conex = DAO.criarConexao();
	
	
	String sql = "SELECT * FROM tb_carteira WHERE id_usuario = ?;";
	
	PreparedStatement ps;
	
	try {
		
		ps = conex.prepareStatement(sql);
		ps.setInt(1, idUsuario);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			car = new Carteira();
			
			car.setId(rs.getInt("id"));
			car.setNomeCarteira(rs.getString("nomeCarteira"));
			car.setDinheiro(rs.getDouble("dinheiro"));			
			
			listaDeCarteira.add(car);
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	
		return listaDeCarteira;
	}

}