import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'mw-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  @ViewChild('ul') ul: ElementRef | undefined;
  @ViewChild('drop') drop: ElementRef | undefined;

  constructor(private renderer: Renderer2) { }

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

  descer(){
      const dropMenu = this.ul?.nativeElement;
      this.renderer.setStyle(dropMenu, 'top', '10%' );
      this.renderer.setStyle(dropMenu, 'opacity', '1' );
      
  }

  teste(){
    const dropMenu = this.ul?.nativeElement;
    this.renderer.setStyle(dropMenu, 'top', '-10%' );
    this.renderer.setStyle(dropMenu, 'opacity', '0' );
  }

  ngOnInit(): void {
  }

}
