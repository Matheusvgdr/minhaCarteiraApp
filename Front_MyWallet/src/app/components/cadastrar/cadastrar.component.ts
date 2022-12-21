import { style } from '@angular/animations';
import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'mw-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.scss']
})
export class CadastrarComponent implements OnInit {

  @ViewChild('teste') teste: ElementRef | undefined;
  @ViewChild('img') img: ElementRef | undefined;

  mover(){
  }
  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {
    this.renderer.listen('document', 'click', () => {
      console.log('teste');
    })
  }

  testar(): void{
    const img = this.img?.nativeElement;
    this.renderer.setStyle(img, 'left', '-100%');
  }

}
