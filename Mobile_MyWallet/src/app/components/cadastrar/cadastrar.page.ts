import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.page.html',
  styleUrls: ['./cadastrar.page.scss'],
})
export class CadastrarPage implements OnInit {

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

  constructor(private servico: UsuarioService) { }

  ngOnInit(): void{
  }

  onSubmit(){
   this.postCadastrarUsuario(this.usuario);
  }

  private postCadastrarUsuario(usuario: Usuario){
    this.servico.postCadastrarUsuario(usuario).subscribe({
      next: (response) => {
        this.usuario = response;
        console.log(response);
      }
    })
  }
}