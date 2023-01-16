import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routes';

import { HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { CadastrarComponent } from './components/cadastrar/cadastrar.component';
import { ReciboComponent } from './components/recibo/recibo.component';
import { CarteirasComponent } from './components/carteiras/carteiras.component';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from './service/usuario.service';
import { NgChartsModule } from 'ng2-charts';
import { BancoService } from './service/banco.service';
import { CarteiraService } from './service/carteira.service';
import { ListaService } from './service/lista.service';
import { MovimentacaoService } from './service/movimentacao.service';
import { TipoTransacaoService } from './service/tipo-transacao.service';
import { TransacaoComponent } from './components/transacao/transacao.component';
import { BancoComponent } from './components/banco/banco.component';
import { CambioComponent } from './components/cambio/cambio.component';
import { PerfilComponent } from './components/perfil/perfil.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    HomeComponent,
    LoginComponent,
    CadastrarComponent,
    ReciboComponent,
    CarteirasComponent,
    TransacaoComponent,
    BancoComponent,
    CambioComponent,
    PerfilComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES),
    HttpClientModule,
    FormsModule,
    NgChartsModule
  ],
  providers: [
    UsuarioService,
    BancoService,
    CarteiraService,
    ListaService,
    MovimentacaoService,
    TipoTransacaoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
