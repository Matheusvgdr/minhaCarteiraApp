import { Component, OnInit } from '@angular/core';
import { Movi } from 'src/app/models/movimentacao.model';
import { Usuario } from 'src/app/models/usuario.model';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'mw-recibo',
  templateUrl: './recibo.component.html',
  styleUrls: ['./recibo.component.scss']
})
export class ReciboComponent implements OnInit {

  constructor(private servico: MovimentacaoService, private UsuarioService: UsuarioService) { }
  
  usu: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  movimentacoes!: Movi[];

  ngOnInit(): void {
    this.getListarMovimentacoes(this.usu.id || 1);
  }

  private getListarMovimentacoes(idUsuario: number){
    this.servico.getListarMovimentacao(idUsuario).subscribe({next: (response) => {this.movimentacoes = response; console.log(response); }})
  }
}