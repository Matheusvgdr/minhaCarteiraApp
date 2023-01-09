import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'mw-carteiras',
  templateUrl: './carteiras.component.html',
  styleUrls: ['./carteiras.component.scss']
})
export class CarteirasComponent implements OnInit {

  @ViewChild('myBtn') btn: ElementRef | undefined;
  @ViewChild('close') close: ElementRef | undefined;
  @ViewChild('myModal') modal: ElementRef | undefined;
  @ViewChild('modalContent') modalContent: ElementRef | undefined;

  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {
  }

  mostrar(){
    const btn = this.btn?.nativeElement;
    const close = this.close?.nativeElement;
    const modal = this.modal?.nativeElement;
    const modalContent = this.modalContent?.nativeElement;

   // this.renderer.setStyle(close, 'display', "none");
    this.renderer.setStyle(modal, 'display', "block");
    this.renderer.setStyle(modalContent, 'top', "0");
    //this.renderer.setStyle(modalContent, 'display', "none");
  }

  fechar(){
    const modal = this.modal?.nativeElement;
    this.renderer.setStyle(modal, 'display', "none");
  }


}
