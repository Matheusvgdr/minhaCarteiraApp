import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';
import { Banco } from 'src/app/models/banco.model';
import { BancoService } from 'src/app/service/banco.service';

@Component({
  selector: 'app-banco',
  templateUrl: './banco.page.html',
  styleUrls: ['./banco.page.scss'],
})
export class BancoPage implements OnInit {

  banco! : Banco[];

  constructor(private service: BancoService, private navControl: NavController) { }

  ngOnInit(): void{
    //this.getListarBanco();
  }

  voltar(){
    this.navControl.navigateForward("home");
  }

  private getListarBanco(){
    this.service.getListarBanco().subscribe({
      next: (response) =>{
        this.banco = response;
        console.log(this.banco);
      }
    })
  }
}