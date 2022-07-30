import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PuntuacionComponent} from "./puntuacion/puntuacion.component";
import {AtletaComponent} from "./atleta/atleta.component";
import {AtletaDetalleComponent} from "./atleta-detalle/atleta-detalle.component";

const routes: Routes = [
  // path: "nombre", component: componente
  {path: "registrarPuntuacion", component: PuntuacionComponent},
  {path: "actualizarFlagsAtleta", component: AtletaComponent},
  {path: "obtenerPuntajePromedio", component: AtletaDetalleComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
