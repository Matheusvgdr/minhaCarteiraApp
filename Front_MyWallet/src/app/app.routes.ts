import { Routes } from "@angular/router";
import { CarteirasComponent } from "./components/carteiras/carteiras.component";
import { HomeComponent } from "./components/home/home.component";
import { ReciboComponent } from "./components/recibo/recibo.component";

export const ROUTES: Routes = [
    {path: "", component: HomeComponent},
    {path: "recibo", component: ReciboComponent},
    {path: "carteiras", component: CarteirasComponent}
    
];