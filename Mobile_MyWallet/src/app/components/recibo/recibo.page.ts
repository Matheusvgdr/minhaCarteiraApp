import { Component, OnInit } from '@angular/core';
import { Movi } from 'src/app/models/movimentacao.model';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';

@Component({
  selector: 'app-recibo',
  templateUrl: './recibo.page.html',
  styleUrls: ['./recibo.page.scss'],
})
export class ReciboPage implements OnInit {

  constructor(private servico: MovimentacaoService) { }

  movimentacoes!: Movi[];

  ngOnInit(): void {
    this.getListarMovimentacoes(1);
  }

  private getListarMovimentacoes(idUsuario: number){
    this.servico.getListarMovimentacao(idUsuario).subscribe({next: (response) => {this.movimentacoes = response; console.log(response); }})
  }

}
