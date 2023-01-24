import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'recibo',
    loadChildren: () => import('./components/recibo/recibo.module').then( m => m.ReciboPageModule)
  },
  {
    path: 'perfil',
    loadChildren: () => import('./components/perfil/perfil.module').then( m => m.PerfilPageModule)
  },
  {
    path: 'transacao',
    loadChildren: () => import('./components/transacao/transacao.module').then( m => m.TransacaoPageModule)
  },
  {
    path: 'cambio',
    loadChildren: () => import('./components/cambio/cambio.module').then( m => m.CambioPageModule)
  },  {
    path: 'banco',
    loadChildren: () => import('./components/banco/banco.module').then( m => m.BancoPageModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./components/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'cadastrar',
    loadChildren: () => import('./components/cadastrar/cadastrar.module').then( m => m.CadastrarPageModule)
  }

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
