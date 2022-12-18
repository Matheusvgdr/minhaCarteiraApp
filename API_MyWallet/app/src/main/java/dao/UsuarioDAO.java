package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

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
				user.setCep(rs.getString("cep"));
				user.setEmail(rs.getString("email"));
				user.setNascimento(rs.getDate("nascimento"));
				user.setNome(rs.getString("nome"));
				user.setTelefone(rs.getString("telefone"));
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

		String sql = "INSERT INTO tb_usuario(nome, email, telefone, nascimento, cep) VALUES(?, ?, ?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = conex.prepareStatement(sql);

			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getTelefone());
			ps.setDate(4, user.getNascimento());
			ps.setString(5, user.getCep());

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

		String sql = "UPDATE tb_usuario SET nome=?, email=?, telefone=?, nascimento=?, cep=? WHERE id=?;";

		try {

			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getTelefone());
			ps.setDate(4, user.getNascimento());
			ps.setString(5, user.getCep());
			
			ps.setInt(6, user.getId());

			retornoQuery = ps.executeUpdate();

			if (retornoQuery <= 0) {
				resultado = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
}
