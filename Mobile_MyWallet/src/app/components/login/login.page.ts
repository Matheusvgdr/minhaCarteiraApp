import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private servico: UsuarioService, private router: Router) { }

  nomeUsuario: string = '';
  senha: string = '';


  ngOnInit(): void{
  }

  onSubmit() {
    this.getLogar(this.nomeUsuario, this.senha);
    
  }

  private getLogar(usuario: string, senha: string) {
    this.servico.getVerificarUsuario(usuario, senha).subscribe({
      next: (response) => {

        if (response == null) {
          console.log("erro");

        } else {

          sessionStorage.setItem("usuario", JSON.stringify(response));
          console.log(sessionStorage);

         this.router.navigate(["home"]);
        }
      }
    })
  }
}
