import { style } from '@angular/animations';
import { DatePipe } from '@angular/common';
import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import {  Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'mw-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.scss']
})
export class CadastrarComponent implements OnInit {

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

  constructor( private servico: UsuarioService) { }

  ngOnInit(): void {
   
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