import { Component, OnInit } from '@angular/core';
import { AlertController, NavController, ToastController } from '@ionic/angular';

@Component({
  selector: 'app-carteira',
  templateUrl: './carteira.page.html',
  styleUrls: ['./carteira.page.scss'],
})
export class CarteiraPage implements OnInit {

  constructor(private alerta: AlertController, private toast: ToastController, private navControl: NavController) { }

  ngOnInit() {
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

}
