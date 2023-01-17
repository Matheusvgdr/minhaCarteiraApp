package service;

import java.util.List;

import dao.BancoDAO;
import model.Banco;



public class BancoService {

	BancoDAO cartao = new BancoDAO();

	public List<Banco> listarBancos() {
		return cartao.listarBancos();
	}
}
