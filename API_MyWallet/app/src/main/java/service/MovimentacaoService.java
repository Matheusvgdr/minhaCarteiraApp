package service;

import java.util.List;

import dao.MovimentacaoDAO;
import model.Movimentacao;

public class MovimentacaoService {
	MovimentacaoDAO mvt = new MovimentacaoDAO();
	
	public List<Movimentacao> litarTransacoes(int idConta){
		
		return mvt.listarTransacoes(idConta);
		
	}
}
