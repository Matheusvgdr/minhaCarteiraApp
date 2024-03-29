import { Component, OnInit } from '@angular/core';
import { Banco } from 'src/app/models/banco.model';
import { Carteira } from 'src/app/models/carteira.model';
import { Movi } from 'src/app/models/movimentacao.model';
import { TT } from 'src/app/models/tipoTransacao.mode';
import { Usuario } from 'src/app/models/usuario.model';
import { BancoService } from 'src/app/service/banco.service';
import { CarteiraService } from 'src/app/service/carteira.service';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';
import { TipoTransacaoService } from 'src/app/service/tipo-transacao.service';

@Component({
  selector: 'mw-transacao',
  templateUrl: './transacao.component.html',
  styleUrls: ['./transacao.component.scss']
})
export class TransacaoComponent implements OnInit {

  tiposT!: TT[];
  bancos!: Banco[]; 
  carteiras!: Carteira[];
  
  dinheiro!: number;
  data!: Date;

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  banco: Banco = {
    id: 0,
    banco: "",
    id_usuario: this.usuario
  }

  carteira: Carteira ={
    id: 0,
    nomeCarteira: "",
    dinheiro: 0,
    id_usuario: this.usuario,
    id_banco: this.banco
  }

  tipo: TT = {
    id: 0,
    descricao: ""
  }
  
  movimentacao: Movi = {
    dataMovimentacao: "",
    dinheiro: 0,
    id_banco: this.banco,
    id_usuario: this.usuario,
    id_tipo: this.tipo
  }

  moviCart: Movi = {
    dataMovimentacao: "",
    dinheiro: 0,
    id_banco: this.banco,
    id_usuario: this.usuario,
    id_tipo: this.tipo
  }

teste(){
  console.log(this.moviCart);
}


  constructor(private servico: TipoTransacaoService, private bancoServ: BancoService, private carteiraServ: CarteiraService, private movimentacaoServ: MovimentacaoService) { }

 
  ngOnInit(): void {
    this.getTipoTransacao();
    this.getListarBanco();
    this.getListarCarteiras(this.usuario.id || 0);
  }

  realizarTransacao(){
    this.postRealizarTransacao();
  }

  transacaoCart(){
    this.transacaoCarteira(this.moviCart);
  }

  private getListarCarteiras(idUsuario: number){
    this.carteiraServ.getListarCarteiras(idUsuario).subscribe({
      next: (response) => {
        this.carteiras = response;
      }
    })
  }

  private getTipoTransacao(){
    this.servico.getListarTipos().subscribe({
      next: (response) => {
        this.tiposT = response;
        console.log(response);
      }
    })
  }

  private getListarBanco(){
    this.bancoServ.getListarBanco().subscribe({
      next: (response) => {
        this.bancos = response;
        console.log(this.bancos);
      }
    })
  }

    private postRealizarTransacao(){
      this.movimentacaoServ.postRealizarTransacao(this.movimentacao).subscribe({
      next: (response) => {
        this.movimentacao = response;
        console.log(response);
      }
    })
  }
  
  private transacaoCarteira(movimentacao: Movi){
    this.movimentacaoServ.postRealizarTransacaoCarteira(movimentacao).subscribe({
      next: (response) =>{
        this.movimentacao = response;
        console.log(response);
      }
    })
  }
}