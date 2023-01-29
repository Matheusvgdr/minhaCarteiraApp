import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carteira } from 'src/app/models/carteira.model';
import { Usuario } from 'src/app/models/usuario.model';
import { CarteiraService } from 'src/app/service/carteira.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'mw-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  constructor(private servico: UsuarioService, private carteiraServ: CarteiraService, private router: Router) { }

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  idUsuario: number = this.usuario.id || 0;
  carteiras!: Carteira[];

  onSubmit(){
    this.postModificarUsuario(this.usuario);
  }
  
  ngOnInit(): void {
    this.getListarCarteiras(this.idUsuario);
  }

  deletarUsuario(){
    this.delDeleteUsuario(this.idUsuario);
  }

  private postModificarUsuario(usuario: Usuario){
    this.servico.postModificarUsuario(usuario).subscribe({
      next: (response) => {
        console.log(response);
      }
    });
  }

  private getListarCarteiras(idUsuario: number) {
    this.carteiraServ.getListarCarteiras(idUsuario).subscribe({
      next: (response) => {
        this.carteiras = response;
      }
    });
  }

  private delDeleteUsuario(idUsuario: number){
    this.servico.delDeletarUsuario(idUsuario).subscribe({
      next: (response) => {
        console.log(response);
        sessionStorage.clear();
        if(sessionStorage.getItem("usuario") == null){
          this.router.navigate([""]);
        }else{
          console.log("continua existindo");
        } 
      }
    });
  }
}