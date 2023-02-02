import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './page/menu/menu.component';
import { HomeComponent } from './page/home/home.component';
import { ClientesComponent } from './page/clientes/clientes.component';
import { CuentasComponent } from './page/cuentas/cuentas.component';
import { ChequerasComponent } from './page/chequeras/chequeras.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'clientes', component: ClientesComponent},
  {path: 'cuentas', component: CuentasComponent},
  {path: 'chequeras', component: ChequerasComponent},
  {path: '**', pathMatch:'full', redirectTo: 'home'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
