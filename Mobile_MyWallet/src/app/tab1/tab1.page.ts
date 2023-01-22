import { Component } from '@angular/core';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
  dias = ['Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab', 'Dom',]
  constructor() {}

  // ngOnInit(){
  //   new Chart('MyChart', {
  //     type: 'line',
  //     data: {
  //       labels: this.dias,
  //       datasets: [{
  //         label: 'Gastos da semana',
  //         data: [12, 19, 3, 5, 2, 3, 32],
  //         borderWidth: 2,
  //         backgroundColor:[
  //           '#fff',
  //         ],
  //          pointBackgroundColor: [
  //           "#fff"
  //          ],
  //          pointBorderColor: [
  //           '#1F1C26'
  //          ],
  //          borderColor: [
  //           "#7E41A0"
  //          ]

  //       }]
  //     },
  //     options: {
  //       scales: {
  //         y: {
  //           beginAtZero: true
  //         }
  //       }
  //     }
  //   });
  // }

}
