import { Routes } from "@angular/router";
import { BancoComponent } from "./components/banco/banco.component";
import { CambioComponent } from "./components/cambio/cambio.component";
import { CarteirasComponent } from "./components/carteiras/carteiras.component";
import { HomeComponent } from "./components/home/home.component";
import { PerfilComponent } from "./components/perfil/perfil.component";
import { ReciboComponent } from "./components/recibo/recibo.component";
import { TransacaoComponent } from "./components/transacao/transacao.component";

export const ROUTES: Routes = [
    {path: "", component: HomeComponent},
    {path: "recibo", component: ReciboComponent},
    {path: "carteiras", component: CarteirasComponent},
    {path: "banco", component: BancoComponent},
    {path: "cambio", component: CambioComponent},
    {path: "perfil", component: PerfilComponent},
    {path: "transacao", component: TransacaoComponent}
    
];