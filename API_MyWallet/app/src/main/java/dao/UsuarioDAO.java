package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	Connection conex = null;

	// PROCURAR USUÁRIO
	public Usuario procurarUsuario(int id) {
		Usuario user = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();

		String sql = "SELECT * FROM tb_usuario WHERE id = ?";

		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new Usuario();

				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setNomeUsuario(rs.getString("nomeUsuario"));
				user.setSenha(rs.getString("senha"));
				user.setTelefone(rs.getString("telefone"));
				user.setNascimento(rs.getDate("nascimento"));
				user.setCidade(rs.getString("cidade"));
				user.setEstado(rs.getString("estado"));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}

	// CADASTRAR USUÁRIO
	public boolean cadastrarUsuario(Usuario user) {
		boolean resultado = true;
		int retornoQuery;
		conex = DAO.criarConexao();

		String sql = "INSERT INTO tb_usuario(nome, email, nomeUsuario, senha, telefone, nascimento, cidade, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);

			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getNomeUsuario());
			ps.setString(4, user.getSenha());
			ps.setString(5, user.getTelefone());
			ps.setDate(6, user.getNascimento());
			ps.setString(7, user.getCidade());
			ps.setString(8, user.getEstado());

			retornoQuery = ps.executeUpdate();

			if (retornoQuery <= 0) {
				resultado = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultado;

	}

	// DELETAR USUÁRIO
	public boolean deletarUsuario(int id) {
		boolean resultado = true;
		int retornoQuery;

		conex = DAO.criarConexao();

		String sql = "DELETE FROM tb_usuario WHERE id = ?;";

		try {

			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setInt(1, id);

			retornoQuery = ps.executeUpdate();

			if (retornoQuery <= 0) {
				resultado = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultado;
	}

	// ALTERAR USUÁRIO
	public boolean modificarUsuario(Usuario user) {
		boolean resultado = true;
		int retornoQuery;

		conex = DAO.criarConexao();

		String sql = "UPDATE tb_usuario SET nome=?, email=?, nomeUsuario=?, senha=?, telefone=?, nascimento=?, cidade=?, estado=? WHERE id=?;";

		try {

			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getNomeUsuario());
			ps.setString(4, user.getSenha());
			ps.setString(5, user.getTelefone());
			ps.setDate(6, user.getNascimento());
			ps.setString(7, user.getCidade());
			ps.setString(8, user.getEstado());
			
			ps.setInt(9, user.getId());

			retornoQuery = ps.executeUpdate();

			if (retornoQuery <= 0) {
				resultado = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	//VERIFICA SE A SENHA E O NOME DE USUÁRIO ESTÃO CORRETOS
	public Usuario verificarUsuario(String nomeUsu, String senha) {
		Usuario usu =null;
		ResultSet rs = null;
		
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_usuario WHERE nomeUsuario = ? AND senha = ?;";
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, nomeUsu);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usu = new Usuario();
				
				usu.setId(rs.getInt("id"));
				usu.setNome(rs.getString("nome"));
				usu.setEmail(rs.getString("email"));
				usu.setNomeUsuario(rs.getString("nomeUsuario"));
				usu.setSenha(rs.getString("senha"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setNascimento(rs.getDate("nascimento"));
				usu.setCidade(rs.getString("cidade"));
				usu.setEstado(rs.getString("estado"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usu;
	}

}
