package service;

import java.util.List;

import dao.MovimentacaoDAO;
import model.Movimentacao;

public class MovimentacaoService {
	MovimentacaoDAO mvt = new MovimentacaoDAO();
	
	//Teste branch lucas
	
	//Retorna uma lista de Transações
	public List<Movimentacao> listarTransacoes(int idConta){
		
		return mvt.listarTransacoes(idConta);
		
	}
}
