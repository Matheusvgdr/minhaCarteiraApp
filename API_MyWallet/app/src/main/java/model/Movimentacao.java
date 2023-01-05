package model;

import java.sql.Date;

public class Movimentacao {
	private int id;
	private Date dataMovimentacao;
	private double dinheiro;
	private TipoTransacao id_tipo;
	private Carteira id_carteira;
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
	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}
	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}
	public double getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public TipoTransacao getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(TipoTransacao id_tipo) {
		this.id_tipo = id_tipo;
	}
	public Carteira getId_carteira() {
		return id_carteira;
	}
	public void setId_carteira(Carteira id_carteira) {
		this.id_carteira = id_carteira;
	}
		
}
