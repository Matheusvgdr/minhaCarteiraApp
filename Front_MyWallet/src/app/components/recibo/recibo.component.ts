import { Component, OnInit } from '@angular/core';
import { Movi } from 'src/app/models/movimentacao.model';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';

@Component({
  selector: 'mw-recibo',
  templateUrl: './recibo.component.html',
  styleUrls: ['./recibo.component.scss']
})
export class ReciboComponent implements OnInit {

  constructor(private servico: MovimentacaoService) { }
  
  movimentacoes!: Movi[];

  ngOnInit(): void {
    this.getListarMovimentacoes(1);
  }


  private getListarMovimentacoes(idUsuario: number){
    this.servico.getListarMovimentacao(idUsuario).subscribe({next: (response) => {this.movimentacoes = response; console.log(response); }})
  }


}
