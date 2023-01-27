import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.page.html',
  styleUrls: ['./perfil.page.scss'],
})
export class PerfilPage implements OnInit {

  constructor(private servico: UsuarioService) { }

  ngOnInit() {
  }

  private getProcurarUsuario(idUsuario: number){
    this.servico.getProcurarUsuario(idUsuario).subscribe({next: (response) =>{console.log(response); }})
  }
}
