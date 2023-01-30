import { Component, Renderer2 } from '@angular/core';
import { Carteira } from '../models/carteira.model';
import { Movi } from '../models/movimentacao.model';
import { Usuario } from '../models/usuario.model';
import { CarteiraService } from '../service/carteira.service';
import { MovimentacaoService } from '../service/movimentacao.service';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  
  carteiras!: Carteira[];
  deposito!: Movi[];
  saque!: Movi[];
  totalDep: number = 0;
  totalSaque: number = 0;
  saldo: number = 0;

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;
  idUsuario: number = this.usuario.id || 0;

  constructor(private renderer: Renderer2, private servico: MovimentacaoService, private carteiraServ: CarteiraService) { }


  movimentacoes!: Movi[];
  dias!: Date[];

  ngOnInit(): void {

    this.getListarMovimentacoes(this.idUsuario);
    this.getListarDepositos(this.usuario.id || 0, 1);
    this.getListarSaques(this.usuario.id || 0, 2);
    this.getListarCarteiras(this.idUsuario);
  }

  getListarDepositos(idConta: number, idTipo: number){
    this.servico.getListarDepositos(idConta, idTipo).subscribe({
      next: (response) => {
        this.deposito = response;
        
        console.log(this.deposito); //Qnt depositos realizados
        this.calcularDep(response);//Calculo dos depositos
      }
    })
  }

   getListarSaques(idConta: number, idTipo: number){
    this.servico.getListarSaques(idConta, idTipo).subscribe({
      next: (response) =>{
        this.saque = response;
        console.log(this.saque);

        this.calcularSaq(response);
      }
    })
  }

  private getListarMovimentacoes(idUsuario: number){
    this.servico.getListarMovimentacao(idUsuario).subscribe({next: (response) => {this.movimentacoes = response; console.log(response); }})
  }

  calcularDep(dinheiro: Movi[]){
    dinheiro.forEach(deposito => {
      this.totalDep += deposito.dinheiro
    })
    console.log(this.totalDep);
  }

  calcularSaq(dinheiro: Movi[]){
    dinheiro.forEach(saque => {
      this.totalSaque += saque.dinheiro;
    })
    console.log(this.totalSaque);
  }

  private getListarCarteiras(idUsuario: number) {
    this.carteiraServ.getListarCarteiras(idUsuario).subscribe({
      next: (response) => {
        this.carteiras = response;
      }
    });
}
}