import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'mw-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private servico: UsuarioService) { }

 
    nomeUsuario: string = '';
    senha: string =  '';
    
  usuario?: Usuario;

  ngOnInit(): void {
  }

  onSubmit(){
   this.getLogar(this.nomeUsuario, this.senha);
  }

  private getLogar(usuario: string, senha: string){
    this.servico.getVerificarUsuario(usuario, senha).subscribe({
      next: (response) => {
        console.log(response);
      }
    })
  }

  //sessionStorage;
}
