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

  usuario!: Usuario;
  carteiras!: Carteira[];
  
  ngOnInit(): void {

    //this.usuario = JSON.parse(sessionStorage.getItem("usuario") || "");
    console.log(sessionStorage.getItem("usuario"));

  }

  private postModificarUsuario(usuario: Usuario){
    this.servico.postModificarUsuario(usuario).subscribe( response => { console.log(response)});
  }

  private getListarCarteiras(idUsuario: number) {
    this.carteiraServ.getListarCarteiras(idUsuario).subscribe({
      next: (response) => {
        this.carteiras = response;
      }
    })
  }

}
