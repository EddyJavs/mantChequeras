import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './page/home/home.component';
import { MenuComponent } from './page/menu/menu.component';
import { NavComponent } from './page/nav/nav.component';
import { ClientesComponent } from './page/clientes/clientes.component';
import { CuentasComponent } from './page/cuentas/cuentas.component';
import { ChequerasComponent } from './page/chequeras/chequeras.component';

import { apiService } from './page/api.service';
import { ChequesComponent } from './page/cheques/cheques.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    NavComponent,
    ClientesComponent,
    CuentasComponent,
    ChequerasComponent,
    ChequesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ apiService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
