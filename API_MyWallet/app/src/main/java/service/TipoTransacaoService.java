package service;

import java.util.List;

import dao.TipoTransacaoDAO;
import model.TipoTransacao;


public class TipoTransacaoService {
	TipoTransacaoDAO tipoT = new TipoTransacaoDAO();
	
	public List<TipoTransacao> listarTipos(){
		
		return tipoT.listarTipoTransacao();
		
	}

}
