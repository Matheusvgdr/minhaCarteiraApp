import { Component, OnInit } from '@angular/core';
import { Usuario } from '../models/usuario.model';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page{

  constructor(private servico: UsuarioService) { }

}
