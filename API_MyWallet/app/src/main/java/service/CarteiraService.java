package service;

import java.util.List;

import dao.CarteiraDAO;
import model.Carteira;

public class CarteiraService {
	CarteiraDAO carteira = new CarteiraDAO();

	public List<Carteira> listarCarteiras(int idConta) {
		return carteira.listarCarteira(idConta);
	}

	public Carteira procurarCarteira(int id) {
		return carteira.procurarCarteira(id);
	}

	public boolean cadastrarCarteira(Carteira cdt) {
		return carteira.cadastrarCarteira(cdt);
	}

	public boolean deletarCarteira(int idCarteira) {
		return carteira.deletarCarteira(idCarteira);
	}

	public boolean modificarCarteira(Carteira cdt) {
		return carteira.modificarCarteira(cdt);
	}
}
