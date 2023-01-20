import { Routes } from "@angular/router";
import { BancoComponent } from "./components/banco/banco.component";
import { CambioComponent } from "./components/cambio/cambio.component";
import { CarteirasComponent } from "./components/carteiras/carteiras.component";
import { HomeComponent } from "./components/home/home.component";
import { PerfilComponent } from "./components/perfil/perfil.component";
import { ReciboComponent } from "./components/recibo/recibo.component";
import { TransacaoComponent } from "./components/transacao/transacao.component";

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router'; // CLI imports router
import { LoginComponent } from "./components/login/login.component";

const ROUTES: Routes = [
    {path: "login", component: LoginComponent},
    {path: "", component: HomeComponent},
    {path: "recibo", component: ReciboComponent},
    {path: "carteiras", component: CarteirasComponent},
    {path: "banco", component: BancoComponent},
    {path: "cambio", component: CambioComponent},
    {path: "perfil", component: PerfilComponent},
    {path: "transacao", component: TransacaoComponent}
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule { }