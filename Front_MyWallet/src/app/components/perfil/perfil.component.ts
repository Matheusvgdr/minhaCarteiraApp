import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'mw-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  constructor(private servico: UsuarioService) { }

  usuario!: Usuario;
  
  ngOnInit(): void {

    //this.usuario = JSON.parse(sessionStorage.getItem("usuario") || "");
    console.log(sessionStorage.getItem("usuario"));

  }

  private getProcurarUsuario(idUsuario: number){
    this.servico.getProcurarUsuario(idUsuario).subscribe({next: (response) =>{console.log(response); }})
  }
}
