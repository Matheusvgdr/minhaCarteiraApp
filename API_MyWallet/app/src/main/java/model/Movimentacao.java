package model;

import java.sql.Date;

public class Movimentacao {
	private int id;
	private Date dataMovimentacao;
	private double dinheiro;
	private Usuario id_usuario;
	private TipoTransacao id_tipo;
	private Carteira id_carteira;
	private Conta id_conta;
	private Cartao id_cartao;
	
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
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
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
		return "Movimentacao [id=" + id + ", dataMovimentacao=" + dataMovimentacao + ", dinheiro=" + dinheiro
				+ ", id_usuario=" + id_usuario + ", id_tipo=" + id_tipo + ", id_carteira=" + id_carteira + ", id_conta="
				+ id_conta + ", id_cartao=" + id_cartao + "]";
	}
	
	
}
