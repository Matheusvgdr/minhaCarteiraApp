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

  @ViewChild('teste') teste: ElementRef | undefined;
  @ViewChild('img') img: ElementRef | undefined;

  mover(){
  }
  constructor(private renderer: Renderer2, private servico: UsuarioService) { }

  ngOnInit(): void {
    // this.renderer.listen('document', 'click', () => {
    //   console.log(this.dat);

    //this.data.transform(new Date(this.testeData), 'MM/dd/yyyy');
    // })
  }

  testar(): void{
    const img = this.img?.nativeElement;
    this.renderer.setStyle(img, 'left', '-100%');
  }

  onSubmit(){
    //console.log(this.nome,this.email,this.nascimento, this.estado, this.cidade);
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