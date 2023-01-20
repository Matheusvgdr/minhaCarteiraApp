import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/service/usuario.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Usuario } from 'src/app/models/usuario.model';

@Component({
  selector: 'mw-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private servico: UsuarioService, private router: Router ) { }

  nomeUsuario: string = '';
  senha: string = '';

  ngOnInit(): void {
    
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
