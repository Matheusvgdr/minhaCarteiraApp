package model;

public class Carteira {
	private int id;
	private String nomeCarteira;
	private double dinheiro;
	private Conta id_conta;
	private Cartao id_cartao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCarteira() {
		return nomeCarteira;
	}
	public void setNomeCarteira(String nomeCarteria) {
		this.nomeCarteira = nomeCarteria;
	}
	
	public double getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public Conta getId_conta() {
		return id_conta;
	}
	public void setId_conta(Conta id_conta) {
		this.id_conta = id_conta;
	}
	public Cartao getId_cartao() {
		return id_cartao;
	}
	public void setId_cartao(Cartao id_cartao) {
		this.id_cartao = id_cartao;
	}
	
}
