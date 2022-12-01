package model;

public class Lista {
	private int id;
	private String conteudo;
	private float dinheiro;
	private Usuario id_usuario;
	private Conta id_conta;
	private Carteira id_carteira;
	private Cartao id_cartao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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
	public Carteira getId_carteira() {
		return id_carteira;
	}
	public void setId_carteira(Carteira id_carteira) {
		this.id_carteira = id_carteira;
	}
	public Cartao getId_cartao() {
		return id_cartao;
	}
	public void setId_cartao(Cartao id_cartao) {
		this.id_cartao = id_cartao;
	}
	
	@Override
	public String toString() {
		return "Lista [id=" + id + ", conteudo=" + conteudo + ", dinheiro=" + dinheiro + ", id_usuario=" + id_usuario
				+ ", id_conta=" + id_conta + ", id_carteira=" + id_carteira + ", id_cartao=" + id_cartao + "]";
	}
	
	
}
