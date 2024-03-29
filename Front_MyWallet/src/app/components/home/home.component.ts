import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Chart } from 'chart.js';
import { Movi } from 'src/app/models/movimentacao.model';
import { Usuario } from 'src/app/models/usuario.model';
import { MovimentacaoService } from 'src/app/service/movimentacao.service';

Chart.defaults.borderColor = '#fff';
Chart.defaults.color = '#fff';

@Component({
  selector: 'mw-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  @ViewChild('ul') ul: ElementRef | undefined;
  @ViewChild('drop') drop: ElementRef | undefined;

  deposito!: Movi[];
  saque!: Movi[];
  totalDep: number = 0;
  totalSaque: number = 0;
  saldo: number = 0;

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;
  idUsuario: number = this.usuario.id || 0;
  constructor(private renderer: Renderer2, private servico: MovimentacaoService) { }


  movimentacoes!: Movi[];
  dias = ["Seg", "Ter", "Quar", "Quin", "Sex", "Sab", "Dom"]

  ngOnInit(): void {

    this.getListarMovimentacoes(this.idUsuario);
    this.getListarDepositos(this.usuario.id || 0, 1);
    this.getListarSaques(this.usuario.id || 0, 2);

    new Chart('MyChart', {
      type: 'line',
      data: {
        labels: this.dias,
        datasets: [{
          label: 'Gastos da semana',
          data: [103.20, 20.50, 0, 68.10, 8.15, 16, 24.90],
          borderWidth: 2,
          backgroundColor:[
            '#fff',
            'tomato',
            'blue'
          ],
           pointBackgroundColor: [
            "#fff"
           ],
           pointBorderColor: [
            '#1F1C26'
           ],
           borderColor: [
            "#7E41A0"
           ]

        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    
    });
  }

   getListarDepositos(idConta: number, idTipo: number){
    this.servico.getListarDepositos(idConta, idTipo).subscribe({
      next: (response) => {
        this.deposito = response;
        
        console.log(this.deposito); //Qnt depositos realizados
        this.calcularDep(response);//Calculo dos depositos
      }
    })
  }

   getListarSaques(idConta: number, idTipo: number){
    this.servico.getListarSaques(idConta, idTipo).subscribe({
      next: (response) =>{
        this.saque = response;
        console.log(this.saque);

        this.calcularSaq(response);
      }
    })
  }

  private getListarMovimentacoes(idUsuario: number){
    this.servico.getListarMovimentacao(idUsuario).subscribe({next: (response) => {this.movimentacoes = response; console.log(response); }})
  }

  calcularDep(dinheiro: Movi[]){
    dinheiro.forEach(deposito => {
      this.totalDep += deposito.dinheiro
    })
    console.log(this.totalDep);
  }

  calcularSaq(dinheiro: Movi[]){
    dinheiro.forEach(saque => {
      this.totalSaque += saque.dinheiro;
    })
    console.log(this.totalSaque);
  }

  mudarTemaLight(){
    this.renderer.addClass(document.body, 'light');
    this.renderer.removeClass(document.body, 'caramel');
    this.renderer.removeClass(document.body, 'grey');
    this.renderer.removeClass(document.body, 'rose');
    this.renderer.removeClass(document.body, 'dark');
  };

  mudarTemaCaramel(){
    this.renderer.addClass(document.body, 'caramel');
    this.renderer.removeClass(document.body, 'light');
    this.renderer.removeClass(document.body, 'grey');
    this.renderer.removeClass(document.body, 'rose');
    this.renderer.removeClass(document.body, 'dark');
  }

  mudarTemaGrey(){
    this.renderer.addClass(document.body, 'grey');
    this.renderer.removeClass(document.body, 'caramel');
    this.renderer.removeClass(document.body, 'light');
    this.renderer.removeClass(document.body, 'rose');
    this.renderer.removeClass(document.body, 'dark');
  }
  
  mudarTemaRose(){
    this.renderer.addClass(document.body, 'rose');
    this.renderer.removeClass(document.body, 'caramel');
    this.renderer.removeClass(document.body, 'grey');
    this.renderer.removeClass(document.body, 'light');
    this.renderer.removeClass(document.body, 'dark');
  }
  mudarTemaDark(){
    this.renderer.addClass(document.body, 'dark');
    this.renderer.removeClass(document.body, 'caramel');
    this.renderer.removeClass(document.body, 'grey');
    this.renderer.removeClass(document.body, 'rose');
    this.renderer.removeClass(document.body, 'light');
  }
    
}