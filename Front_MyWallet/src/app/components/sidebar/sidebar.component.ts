import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'mw-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit(): void {
  }
  
  logout(){
    sessionStorage.clear();
    this.router.navigate([""]);
  }
}