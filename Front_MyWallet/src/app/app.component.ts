import { Component } from '@angular/core';

@Component({
  selector: 'mw-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontMwAngular';
  
  mostrarSidebar: boolean = sessionStorage.getItem("usuario") == null ? false : true;

}
