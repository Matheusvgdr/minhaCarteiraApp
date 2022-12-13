import { Component, OnInit } from '@angular/core';

declare const teste: any;
@Component({
  selector: 'mw-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  
  myfun(){
    teste();
  };
  constructor() { }

  ngOnInit(): void {
  }

}
