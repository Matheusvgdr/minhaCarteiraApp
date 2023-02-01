import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'mw-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  @Input() exibirSidebarEmitter: EventEmitter<boolean> = new EventEmitter();

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.exibirSidebarEmitter.subscribe((x) => {
      console.log(x);
      
    })
  }
  
loadRoute(){
  this.router.navigate(["home"]);
}

  logout(){
    sessionStorage.clear();
    this.router.navigate([""]);
  }
}