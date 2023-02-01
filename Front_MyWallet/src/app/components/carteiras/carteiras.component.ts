import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Banco } from 'src/app/models/banco.model';
import { Carteira } from 'src/app/models/carteira.model';
import { Usuario } from 'src/app/models/usuario.model';
import { BancoService } from 'src/app/service/banco.service';
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

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  carteiras!: Carteira[];
  bancos!: Banco[];

  banco: Banco = {
    banco: "",
    id_usuario: this.usuario
  }
  
  carteira: Carteira ={
    nomeCarteira: "",
    dinheiro: 0,
    id_usuario: this.usuario,
    id_banco: this.banco

  }

  cart: Carteira={
    nomeCarteira: "",
    dinheiro: 0,
    id_usuario: this.usuario,
    id_banco: this.banco
  }

  constructor(private renderer: Renderer2, private servico: CarteiraService, private bancoServ: BancoService) { }


  ngOnInit(): void {
    this.getListarCarteiras(this.usuario.id || 0);
    this.getListarBanco();
  }

  onSubmit() {
    this.cadastrarCarteira(this.carteira);   
  }

  apagarCarteira(idCarteira: number){
    this.servico.delDeletarCarteira(idCarteira).subscribe({
      next: (response) => {
        window.location.reload();
        console.log(response);        
      }
    });
  }

  editarCarteira(){
    this.editCarteira(this.cart);
  }

  teste(){
    console.log(this.cart);
  }

  private editCarteira(carteira: Carteira){
    this.servico.postModificarCarteira(carteira).subscribe({
      next: (response) => {
       // window.location.reload();
        console.log(response);
      }
    })
  }

  private getListarBanco(){
    this.bancoServ.getListarBanco().subscribe({
      next: (response) => {
        this.bancos = response;
        console.log(this.bancos);
      }
    })
  }

  private cadastrarCarteira(carteira: Carteira) {
    this.servico.postCadastrarCarteira(carteira).subscribe({
       next: (response) => {
         window.location.reload();
         console.log(response); 
        } 
      });
  }

  private getListarCarteiras(idUsuario: number) {
    this.servico.getListarCarteiras(idUsuario).subscribe({
       next: (response) => {
         this.carteiras = response;
          console.log(response); 
        } 
      });
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