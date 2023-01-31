import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'tabs',
    loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./tab2/tab2.module').then(m => m.Tab2PageModule)
  },
  {
    path: 'perfil',
    loadChildren: () => import('./tab3/tab3.module').then(m => m.Tab3PageModule)
  },
  {
    path: 'recibo',
    loadChildren: () => import('./components/recibo/recibo.module').then( m => m.ReciboPageModule)
  },
  {
    path: 'transacao',
    loadChildren: () => import('./components/transacao/transacao.module').then( m => m.TransacaoPageModule)
  },
  {
    path: 'cambio',
    loadChildren: () => import('./components/cambio/cambio.module').then( m => m.CambioPageModule)
  },
  {
    path: 'banco',
    loadChildren: () => import('./components/banco/banco.module').then( m => m.BancoPageModule)
  },
  {
    path: '',
    loadChildren: () => import('./components/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'cadastrar',
    loadChildren: () => import('./components/cadastrar/cadastrar.module').then( m => m.CadastrarPageModule)
  },
  {
    path: 'carteira',
    loadChildren: () => import('./components/carteira/carteira.module').then( m => m.CarteiraPageModule)
  }

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
