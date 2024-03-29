import { Component, OnInit } from '@angular/core';
import { Movi } from 'src/app/models/movimentacao.model';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';

@Component({
  selector: 'mw-cambio',
  templateUrl: './cambio.component.html',
  styleUrls: ['./cambio.component.scss']
})
export class CambioComponent implements OnInit {

  deposito!: Movi[];
  saque!: Movi[];
  teste!: Movi;
  totalDep: number = 0;
  totalSaque: number = 0;
  saldo: number = 0;

  moedas: any = [
    {nome: "Dollar", icon: "$", valor: 5.13},
    {nome: "Libra", icon: "£", valor: 6.32},
    {nome: "Peso", icon: "$", valor: 0.27},
    {nome: "Yen", icon: "¥", valor: 0.039},
    {nome: "Euro", icon: "Є", valor: 5.55},
    {nome: "Franco", icon: "fr", valor: 5.53}
  ]

  constructor(private servico: MovimentacaoService) { }

  ngOnInit() {
    this.getListarDepositos(1,1);
    this.getListarSaques(1,2);
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

  calcularDep(dinheiro: Movi[]){
    dinheiro.forEach(deposito => {
      this.totalDep += deposito.dinheiro
    })
    console.log(this.totalDep);

    /* for(let i = 0; i < dinheiro.length; i++){
      this.total += dinheiro[i].dinheiro;
    } */
  }

  calcularSaq(dinheiro: Movi[]){
    dinheiro.forEach(saque => {
      this.totalSaque += saque.dinheiro;
    })
    console.log(this.totalSaque);
  }
}