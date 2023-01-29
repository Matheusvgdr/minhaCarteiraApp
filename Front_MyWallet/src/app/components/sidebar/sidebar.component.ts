import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'mw-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  
  constructor( private router: Router, private exibirSidebarEmitter: EventEmitter<boolean>) { }

  ngOnInit(): void {
    this.exibirSidebarEmitter.subscribe(() => {
      this.loadRoute();
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