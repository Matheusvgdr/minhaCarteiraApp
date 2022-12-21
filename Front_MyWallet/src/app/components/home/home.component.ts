import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'mw-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

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

  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {
  }

}
