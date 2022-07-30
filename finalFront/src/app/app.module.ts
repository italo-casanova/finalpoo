import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AtletaComponent } from './atleta/atleta.component';
import { AtletaDetalleComponent } from './atleta-detalle/atleta-detalle.component';
import { PuntuacionComponent } from './puntuacion/puntuacion.component';

@NgModule({
  declarations: [
    AppComponent,
    AtletaComponent,
    AtletaDetalleComponent,
    PuntuacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
