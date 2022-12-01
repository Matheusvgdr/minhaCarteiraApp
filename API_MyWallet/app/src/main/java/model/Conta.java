package model;

public class Conta {
	private int id;
	private String nomeUsuario;
	private String senha;
	private Usuario id_usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@Override
	public String toString() {
		return "Conta [id=" + id + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", id_usuario=" + id_usuario
				+ "]";
	}
	
	
}
