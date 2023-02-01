import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';
import { Movi } from 'src/app/models/movimentacao.model';
import { Usuario } from 'src/app/models/usuario.model';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-recibo',
  templateUrl: './recibo.page.html',
  styleUrls: ['./recibo.page.scss'],
})
export class ReciboPage implements OnInit {

  constructor(private servico: MovimentacaoService, private navControl: NavController,  private UsuarioService: UsuarioService) { }

  usu: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  movimentacoes!: Movi[];

  ngOnInit(): void {
    this.getListarMovimentacoes(this.usu.id || 1);
  }

  private getListarMovimentacoes(idUsuario: number){
    this.servico.getListarMovimentacao(idUsuario).subscribe({next: (response) => {this.movimentacoes = response; console.log(response); }})
  }

  voltar(){
    this.navControl.navigateForward("home");
  }
}