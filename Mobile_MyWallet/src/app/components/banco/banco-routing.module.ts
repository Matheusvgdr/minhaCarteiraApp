import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BancoPage } from './banco.page';

const routes: Routes = [
  {
    path: '',
    component: BancoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BancoPageRoutingModule {}
