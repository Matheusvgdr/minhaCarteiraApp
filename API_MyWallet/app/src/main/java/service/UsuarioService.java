package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	
	UsuarioDAO usuario = new UsuarioDAO();
	
	//Procura um usuário a partir de um id
	public Usuario procurarUsuario(int idUsuario){
		
		return usuario.procurarUsuario(idUsuario);

	}
	
	//Cadastra um usuário no banco de dados
	public boolean cadastrarUsuario(Usuario usu){
		
		return usuario.cadastrarUsuario(usu);
	}
	
	//Deleta um usuário do banco de dados
	public boolean deletarUsuario(int idUsuario){

		return usuario.deletarUsuario(idUsuario);

	}
	
	//Modifica um usuário do banco de dados
	public boolean  modificarUsuario(Usuario usu){

		return usuario.modificarUsuario(usu);
	}
	
	public Usuario verificarUsuario(String nomeUsu, String senha) {
		return usuario.verificarUsuario(nomeUsu, senha);
	}
}
