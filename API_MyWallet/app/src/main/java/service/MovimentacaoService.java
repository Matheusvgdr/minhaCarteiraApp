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
	
	public Movimentacao procurarPorId(int id){
		
		return mvt.procurarPorId(id);
	}
	
	public boolean realizarTransacao(Movimentacao movi) {
		boolean resultado = true;
		
		if(mvt.verificarSaldo(movi)) {
			
			mvt.realizarTransacao(movi);
			
		}else {
			
			resultado = false;
			
		}
		return resultado;
	}
	
	public List<Movimentacao> listarSaques (int idConta, int idTipo){
		
		return mvt.listarSaques(idConta, idTipo);
	}
	
	public List<Movimentacao> listarDepositos(int idConta, int idTipo){
		
		return mvt.listarDepositos(idConta, idTipo);
	}
	
	public boolean realizarTransacaoCarteira(Movimentacao movi) {
		boolean resultado = true;
		
		if(mvt.verificarSaldo(movi)) {
			
			mvt.realizarTransacaoCarteira(movi);
		
		}else {
			 resultado = false;
		}
		return resultado;
	}
	
}

