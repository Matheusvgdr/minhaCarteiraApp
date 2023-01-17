import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Chart } from 'chart.js';

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

  constructor(private renderer: Renderer2) { }

  dias = ['Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab', 'Dom',]

  ngOnInit(): void {
    new Chart('MyChart', {
      type: 'line',
      data: {
        labels: this.dias,
        datasets: [{
          label: 'Gastos da semana',
          data: [12, 19, 3, 5, 2, 3, 32],
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
