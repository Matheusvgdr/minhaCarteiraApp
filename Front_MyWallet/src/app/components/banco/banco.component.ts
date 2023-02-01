import { Component, OnInit } from '@angular/core';
import { Banco } from 'src/app/models/banco.model';
import { Usuario } from 'src/app/models/usuario.model';
import { BancoService } from 'src/app/service/banco.service';

@Component({
  selector: 'mw-banco',
  templateUrl: './banco.component.html',
  styleUrls: ['./banco.component.scss']
})
export class BancoComponent implements OnInit {

  usuario: Usuario = JSON.parse(sessionStorage.getItem("usuario") || "") as Usuario;

  banco!: Banco[]; 
  
  banc: Banco = {
    banco: "",
    id_usuario: this.usuario
  }

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