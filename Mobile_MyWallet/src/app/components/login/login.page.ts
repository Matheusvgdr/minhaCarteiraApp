import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  slideOpts = {
    initialSlide: 1,
    speed: 400
  };

  constructor(private servico: UsuarioService, private router: Router) { }

  nomeUsuario: string = '';
  senha: string = '';

  usuario: Usuario = {
    nome: '',
    email: '',
    nomeUsuario: '',
    senha: '',
    telefone: '',
    nascimento: '',
    cidade: '',
    estado: ''
  }

  ngOnInit(): void{
  }

  onSubmit() {
    this.getLogar(this.nomeUsuario, this.senha);
    this.postCadastrarUsuario(this.usuario);
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

  private postCadastrarUsuario(usuario: Usuario){
    this.servico.postCadastrarUsuario(usuario).subscribe({
      next: (response) => {
        this.usuario = response;
        console.log(response);

        sessionStorage.clear();
        if(sessionStorage.getItem("usuario") == null){
          this.router.navigate([""]);
        }else{
          console.log("não redirecionou");
        } 
      }
    })
  }
}
