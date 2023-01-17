import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Carteira } from 'src/app/models/carteira.model';
import { Usuario } from 'src/app/models/usuario.model';
import { CarteiraService } from 'src/app/service/carteira.service';

@Component({
  selector: 'mw-carteiras',
  templateUrl: './carteiras.component.html',
  styleUrls: ['./carteiras.component.scss']
})
export class CarteirasComponent implements OnInit {

  @ViewChild('myBtn') btn: ElementRef | undefined;
  @ViewChild('close') close: ElementRef | undefined;
  @ViewChild('myModal') modal: ElementRef | undefined;
  @ViewChild('modalContent') modalContent: ElementRef | undefined;

  constructor(private renderer: Renderer2, private servico: CarteiraService) { }

  ngOnInit(): void {
  }

  usuario: Usuario = {
      id: 1,
      nome: '',
      email: '',
      nomeUsuario: '',
      senha: '',
      telefone: '',
      nascimento: '',
      cidade: '',
      estado: ''
  }
  carteira: Carteira = {
    nomeCarteira: "Teste",
    dinheiro: 150,
    id_usuario: this.usuario,
    id_banco: {
      banco: "nubank",
      id_usuario: this.usuario
    } 
  }

  onSubmit(){
    this.servico.postCadastrarCarteira(this.carteira);

  }

  private postCadastrarCarteria(carteira:Carteira){
  this.servico.postCadastrarCarteira(carteira).subscribe({
    next: (response) => {
      console.log(response);
    }
  })
  }

  mostrar(){
    const btn = this.btn?.nativeElement;
    const close = this.close?.nativeElement;
    const modal = this.modal?.nativeElement;
    const modalContent = this.modalContent?.nativeElement;

   // this.renderer.setStyle(close, 'display', "none");
    this.renderer.setStyle(modal, 'display', "block");
    this.renderer.setStyle(modalContent, 'top', "0");
    //this.renderer.setStyle(modalContent, 'display', "none");
  }

  fechar(){
    const modal = this.modal?.nativeElement;
    this.renderer.setStyle(modal, 'display', "none");
  }


}
