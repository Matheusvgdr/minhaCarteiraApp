import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';
import { Banco } from 'src/app/models/banco.model';
import { TT } from 'src/app/models/tipoTransacao.mode';
import { BancoService } from 'src/app/service/banco.service';
import { TipoTransacaoService } from 'src/app/service/tipo-transacao.service';

@Component({
  selector: 'app-transacao',
  templateUrl: './transacao.page.html',
  styleUrls: ['./transacao.page.scss'],
})
export class TransacaoPage implements OnInit {
  tiposT!: TT[];
  bancos!: Banco[];

  constructor(private servico: TipoTransacaoService, private bancoServ: BancoService, private navControl: NavController) { }

  voltar(){
    this.navControl.navigateForward("home");
  }

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
}