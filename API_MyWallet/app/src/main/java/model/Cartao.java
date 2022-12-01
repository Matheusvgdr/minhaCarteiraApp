package model;

public class Cartao {
	private int id;
	private String banco;
	private Usuario id_usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@Override
	public String toString() {
		return "Cartao [id=" + id + ", banco=" + banco + ", id_usuario=" + id_usuario + "]";
	}
	
	
}
