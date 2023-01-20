import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'mw-cambio',
  templateUrl: './cambio.component.html',
  styleUrls: ['./cambio.component.scss']
})
export class CambioComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  cambios = [
    {moeda: "Dollar"},
    {moeda: "Euro"},
    {moeda: "Libra"},
    {moeda: "Real"},
    {moeda: "Yen"},
    {moeda: "Dollar"}
  ]

}
