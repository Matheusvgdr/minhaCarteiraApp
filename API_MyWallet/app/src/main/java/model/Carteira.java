package model;

public class Carteira {
	private int id;
	private String nomeCarteria;
	private float dinheiro;
	private Usuario id_usuario;
	private Conta id_conta;
	private Cartao id_cartao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCarteria() {
		return nomeCarteria;
	}
	public void setNomeCarteria(String nomeCarteria) {
		this.nomeCarteria = nomeCarteria;
	}
	
	public float getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(float dinheiro) {
		this.dinheiro = dinheiro;
	}
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
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
	
	@Override
	public String toString() {
		return "Carteira [id=" + id + ", nomeCarteria=" + nomeCarteria + ", id_usuario=" + id_usuario + ", id_conta="
				+ id_conta + ", id_cartao=" + id_cartao + "]";
	}
	
	
}
