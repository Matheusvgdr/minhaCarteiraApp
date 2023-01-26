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

  usuario: Usuario = {
    id: 1,
    nome: 'Lucas',
    email: 'lucas@gmail.com',
    nomeUsuario: 'Luc14',
    senha: '12345',
    telefone: '(21)98563-1245',
    nascimento: '2000-02-05',
    cidade: 'São Gonçalo',
    estado: 'RJ'
  }

  carteiras!: Carteira[];

  modelo!: Carteira;

  ngOnInit(): void {
    this.getListarCarteiras(1);
  }

  onSubmit() {
    //this.servico.postCadastrarCarteira(this.carteira);
  }

  private postCadastrarCarteria(carteira: Carteira) {
    this.servico.postCadastrarCarteira(carteira).subscribe({ next: (response) => { console.log(response); } })
  }

  private getListarCarteiras(idUsuario: number) {
    this.servico.getListarCarteiras(idUsuario).subscribe({ next: (response) => { this.carteiras = response; console.log(response); } });
  }

  mostrar() {
    const btn = this.btn?.nativeElement;
    const close = this.close?.nativeElement;
    const modal = this.modal?.nativeElement;
    const modalContent = this.modalContent?.nativeElement;

    // this.renderer.setStyle(close, 'display', "none");
    this.renderer.setStyle(modal, 'display', "block");
    this.renderer.setStyle(modalContent, 'top', "0");
    //this.renderer.setStyle(modalContent, 'display', "none");
  }

  fechar() {
    const modal = this.modal?.nativeElement;
    this.renderer.setStyle(modal, 'display', "none");
  }
}