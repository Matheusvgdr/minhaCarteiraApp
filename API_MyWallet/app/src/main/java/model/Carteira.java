package model;

public class Carteira {
	private int id;
	private String nomeCarteira;
	private double dinheiro;
	private Usuario id_usuario;
	private Banco id_banco;
	
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Banco getId_banco() {
		return id_banco;
	}
	public void setId_banco(Banco id_banco) {
		this.id_banco = id_banco;
	}
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

	
}
