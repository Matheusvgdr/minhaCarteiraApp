package service;

import java.util.List;

import dao.ListaDAO;
import model.Lista;

public class ListaService {
	ListaDAO list = new ListaDAO();
	
public Lista procurarItem(int id){
		
		return list.procurarItem(id);
	}

public boolean cadastrarItem(Lista item){
	
	return list.cadastrarItem(item);
	}

public boolean deletarLista(int idItem){
	
	return list.deletarItem(idItem);

	}

public boolean  modificarLista(Lista item){

	return list.modificarItem(item);
	
	}

public List<Lista> listarItem(int idConta){
	
	return list.listarItens(idConta);
	
}

}
