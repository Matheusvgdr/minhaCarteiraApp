import { Component, OnInit } from '@angular/core';
import { Banco } from 'src/app/models/banco.model';
import { BancoService } from 'src/app/service/banco.service';

@Component({
  selector: 'mw-banco',
  templateUrl: './banco.component.html',
  styleUrls: ['./banco.component.scss']
})
export class BancoComponent implements OnInit {

  banco!: Banco; 

  constructor(private servico: BancoService) { }

  ngOnInit(): void {
    this.getListarBanco();
  }

  private getListarBanco(){
    this.servico.getListarBanco().subscribe({
      next: (response) => {
        this.banco = response;
        console.log(this.banco);
      }
    })
  }
}