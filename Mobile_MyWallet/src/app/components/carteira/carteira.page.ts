import { Component, OnInit } from '@angular/core';
import { AlertController, NavController, ToastController } from '@ionic/angular';
import { Banco } from 'src/app/models/banco.model';
import { Carteira } from 'src/app/models/carteira.model';
import { Usuario } from 'src/app/models/usuario.model';
import { BancoService } from 'src/app/service/banco.service';
import { CarteiraService } from 'src/app/service/carteira.service';

@Component({
  selector: 'app-carteira',
  templateUrl: './carteira.page.html',
  styleUrls: ['./carteira.page.scss'],
})
export class CarteiraPage implements OnInit {

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  carteiras!: Carteira[];


  banc: Banco = {
    banco: "",
    id_usuario: this.usuario
  }
  
  carteira: Carteira ={
    nomeCarteira: "",
    dinheiro: 0,
    id_usuario: this.usuario,
    id_banco: this.banc

  }

  bancos!: Banco[];


  constructor(private alerta: AlertController, private toast: ToastController, private navControl: NavController, private servico: CarteiraService, private bancoServ: BancoService) { }

  ngOnInit() {
    this.getListarCarteiras(this.usuario.id || 0);
    this.getListarBanco();
  }

  voltar(){
    this.navControl.navigateForward("home");
  }

  async adicionarCarteira() {
    const ALERTA = await this.alerta.create({
      header: 'Dê um nome a sua carteira.',
      inputs: [
        { name: 'carteira', type: 'text', placeholder: 'Digite o nome da carteira' }
      ],
      buttons: [
        { text: 'Cancelar', handler: () => { console.log('cancelou'); } },
        {
          text: 'Adicionar', handler: (carteira) => {
            console.log(carteira)
          }
        }
      ]
    });

    ALERTA.present();
  }

  async editar(){
    const ALERTA = await this.alerta.create({
      header: 'Qual o novo nome da carteira?',
      inputs: [
        { name: 'carteira', type: 'text', placeholder: 'Digite o novo nome' }
      ],
      buttons: [
        { text: 'Cancelar', handler: () => { console.log('cancelou'); } },
        {
          text: 'Adicionar', handler: (carteira) => {
            console.log(carteira)
          }
        }
      ]
    });

    ALERTA.present();
  }

  async excluir(){
    const ALERTA = await this.alerta.create({
      header: 'Deseja realmente excluir?',
      buttons: [
        {
          text: 'Cancelar',
          handler: () => {
            console.log('cancelou');
          }
        },
        {
          text: 'Sim',
          handler: async () => {
            const TOAST = await this.toast.create({
              message: 'Carteira apagada',
              duration: 2000,
              position: 'top',
              color: 'success'
            });
            TOAST.present();
          }
          
        }
      ]
    });

    ALERTA.present();
  }

  async inserirDinheiro(){
    const ALERTA = await this.alerta.create({
      header: 'Quanto deseja inserir ou retirar?',
      inputs: [
        { name: 'dinheiro', type: 'number', placeholder: 'Digite o valor' }
      ],
      buttons: [
        { text: 'Cancelar', handler: () => { console.log('cancelou'); } },
        {
          text: 'Adicionar', handler: (carteira) => {
            console.log(carteira)
          }
        }
      ]
    });
    ALERTA.present();
  }

  /* ===================================================== */

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
}