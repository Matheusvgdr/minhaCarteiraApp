package service;

import dao.ContaDAO;
import model.Conta;

public class ContaService {
ContaDAO cnt = new ContaDAO();
	
	public Conta procurarConta(int idConta){
		
		return cnt.procurarConta(idConta);
	}
	
	public boolean cadastrarConta(Conta cont){
		
		return cnt.cadastrarConta(cont);
	}
	
	public boolean deletarConta(int idConta){

		return cnt.deletarConta(idConta);

	}
	
	public boolean modificarConta(Conta cont){

		return cnt.modificarConta(cont);
	}
	
	public Conta verificarConta(String nomeUsu, String senha){

		return cnt.verificarConta(nomeUsu, senha);
	}
	
	

}
