import { Component, OnInit } from '@angular/core';
import { Usuario } from '../models/usuario.model';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit{

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
