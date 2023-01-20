import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'mw-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  constructor(private servico: UsuarioService) { }

  ngOnInit(): void {
  }

  private getProcurarUsuario(idUsuario: number){
    this.servico.getProcurarUsuario(idUsuario).subscribe({next: (response) =>{console.log(response); }})
  }
}
