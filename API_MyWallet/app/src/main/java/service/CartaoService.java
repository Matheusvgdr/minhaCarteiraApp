package service;

import java.util.List;

import dao.CartaoDAO;
import model.Cartao;



public class CartaoService {

	CartaoDAO cartao = new CartaoDAO();

	public List<Cartao> listarCartao() {
		return cartao.listarCartao();
	}
}
