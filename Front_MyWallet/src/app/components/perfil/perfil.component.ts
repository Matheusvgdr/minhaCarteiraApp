import { Component, OnInit } from '@angular/core';
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

  constructor(private servico: UsuarioService, private carteiraServ: CarteiraService) { }

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  carteiras!: Carteira[];

  onSubmit(){
    this.postModificarUsuario(this.usuario);
  }
  
  ngOnInit(): void {
  }

  private postModificarUsuario(usuario: Usuario){
    this.servico.postModificarUsuario(usuario).subscribe({next: (response) => {console.log(response);}});
  }

  private getListarCarteiras(idUsuario: number) {
    this.carteiraServ.getListarCarteiras(idUsuario).subscribe({
      next: (response) => {
        this.carteiras = response;
      }
    })
  }

}
