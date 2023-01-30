import { Component, OnInit } from '@angular/core';
import { Banco } from 'src/app/models/banco.model';
import { Carteira } from 'src/app/models/carteira.model';
import { TT } from 'src/app/models/tipoTransacao.mode';
import { Usuario } from 'src/app/models/usuario.model';
import { BancoService } from 'src/app/service/banco.service';
import { CarteiraService } from 'src/app/service/carteira.service';
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

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;


  constructor(private servico: TipoTransacaoService, private bancoServ: BancoService, private carteiraServ: CarteiraService) { }

 
  ngOnInit(): void {
    this.getTipoTransacao();
    this.getListarBanco();
    this.getListarCarteiras(this.usuario.id || 0);
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
}