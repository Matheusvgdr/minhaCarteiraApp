import { Component, OnInit } from '@angular/core';
import { Banco } from 'src/app/models/banco.model';
import { Movi, Movi, Movi } from 'src/app/models/movimentacao.model';
import { TT } from 'src/app/models/tipoTransacao.mode';
import { BancoService } from 'src/app/service/banco.service';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';
import { TipoTransacaoService } from 'src/app/service/tipo-transacao.service';

@Component({
  selector: 'mw-transacao',
  templateUrl: './transacao.component.html',
  styleUrls: ['./transacao.component.scss']
})
export class TransacaoComponent implements OnInit {

  constructor(private servico: TipoTransacaoService, private bancoServ: BancoService, private MoviService: MovimentacaoService) { }

  tiposT!: TT[];
  bancos!: Banco[]; 
  movi!: Movi;

  ngOnInit(): void {
    this.getTipoTransacao();
    this.getListarBanco();
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
    this.MoviService.postRealizarTransacao().subscribe({
      next: (response) => {
        this.movi = response;
        console.log(response);
      }
    })
  }
}