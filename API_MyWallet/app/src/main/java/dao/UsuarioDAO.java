package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	Connection conex = null;
	
	//Retorna um usuário baseado no id passado por parâmetro
	public Usuario procurarUsuario(int id) {
		
		Usuario usu = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_usuario WHERE id = ?;";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usu = new Usuario();
				
				usu.setId(rs.getInt("id"));
				usu.setNome(rs.getString("nome"));
				usu.setEmail(rs.getString("email"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setNascimento(rs.getDate("nascimento"));
				usu.setCep(rs.getString("cep"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return usu;
		
	}
	
	//Insere um novo usuário na banco de dados
	public boolean cadastrarUsuario(Usuario usu) {
		
		boolean resultado = true;
		int retornoQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "INSERT INTO tb_usuario(nome, email, telefone, nascimento, cep) VALUES(?, ?, ?, ?, ?)";;
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setString(1, usu.getNome());
			ps.setString(2, usu.getEmail());
			ps.setString(3, usu.getTelefone());
			ps.setDate(4, usu.getNascimento());
			ps.setString(5, usu.getCep());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				
				resultado = false;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
				
	}
	
	//Deleta um usuário do banco de dados
	public boolean deletarUsuario(int id) {
		
		boolean resultado = true;
		int retornoQuery;
		conex = DAO.criarConexao();
		
		String sql = "DELETE FROM tb_usuario WHERE id = ?;";
		
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
	
	//Modifica um usuário do banco de dados
	public boolean modificarUsuario(Usuario usu) {
		
		boolean resultado = true;
		int retornoQuery;
		conex = DAO.criarConexao();
		
		String sql = "UPDATE tb_usuario SET nome = ?, email = ?, telefone = ?, nascimento = ?, cep = ? ;";
		
		PreparedStatement ps;
		
		try {
			ps = conex.prepareStatement(sql);
			
			ps.setString(1, usu.getNome());
			ps.setString(2, usu.getEmail());
			ps.setString(3, usu.getTelefone());
			ps.setDate(4, usu.getNascimento());
			ps.setString(5, usu.getCep());
			
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

