package service;

import java.util.List;

import dao.ListaDAO;
import model.Item;

public class ListaService {
	ListaDAO list = new ListaDAO();
	
public Item procurarItem(int id){
		
		return list.procurarItem(id);
	}

public boolean cadastrarItem(Item item){
	
	return list.cadastrarItem(item);
	}

public boolean deletarLista(int idItem){
	
	return list.deletarItem(idItem);

	}

public boolean  modificarLista(Item item){

	return list.modificarItem(item);
	
	}

public List<Item> listarItem(int idConta){
	
	return list.listarItens(idConta);
	
	}
}