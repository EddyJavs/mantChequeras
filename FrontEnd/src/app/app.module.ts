import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './page/home/home.component';
import { MenuComponent } from './page/menu/menu.component';
import { NavComponent } from './page/nav/nav.component';
import { ClientesComponent } from './page/clientes/clientes.component';
import { CuentasComponent } from './page/cuentas/cuentas.component';
import { ChequerasComponent } from './page/chequeras/chequeras.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    NavComponent,
    ClientesComponent,
    CuentasComponent,
    ChequerasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
