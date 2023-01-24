import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { BancoPageRoutingModule } from './banco-routing.module';

import { BancoPage } from './banco.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    BancoPageRoutingModule
  ],
  declarations: [BancoPage]
})
export class BancoPageModule {}
