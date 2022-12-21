package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conta;

public class ContaDAO {
	Connection conex = null;
	
	public Conta procurarConta(int id){
		Conta conta = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_conta WHERE id = ?";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				conta = new Conta();
				
				conta.setId(rs.getInt("id"));
				conta.setNomeUsuario(rs.getString("nomeUsuario"));
				conta.setSenha(rs.getString("senha"));
				conta.getId_usuario().setId(rs.getInt("is_usuario"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conta;
	}
	
	public boolean cadastrarConta(Conta conta) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_conta(nomeUsuario, senha, id_usuario) VALUES (?, ?, ?);";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setString(1, conta.getNomeUsuario());
			ps.setString(2, conta.getSenha());
			ps.setInt(3, conta.getId_usuario().getId());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public boolean deletarConta(int id) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "DELETE FROM tb_conta WHERE id = ?";
		
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
	
	public boolean modificarConta(Conta conta) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "UPDATE tb_conta SET nomeUsuario = ?, senha = ?, id_usuario = ?;";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, conta.getNomeUsuario());
			ps.setString(2, conta.getSenha());
			ps.setInt(3, conta.getId_usuario().getId());
			
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

	public Conta verificarConta(String nomeUsu, String senha) {
		Conta cnt = null;
		ResultSet rs = null;
		
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_usuario WHERE nomeUsuario = ? AND senha = ?";
		
		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setString(1, nomeUsu);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = new Conta();
				
				cnt.setId(rs.getInt("id"));
				cnt.setNomeUsuario(rs.getString("nomeUsuario"));
				cnt.setSenha(rs.getString("senha"));
				cnt.getId_usuario().setId(rs.getInt("id_usuario"));
			}
			
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		return cnt;
	}
}
