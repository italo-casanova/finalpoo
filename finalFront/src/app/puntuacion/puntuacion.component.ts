import { Component, OnInit } from '@angular/core';
import {ApiService} from "../api.service";
import {puntaje} from "../interfaces";
import {catchError, Observable, retry} from "rxjs";

@Component({
  selector: 'app-puntuacion',
  templateUrl: './puntuacion.component.html',
  styleUrls: ['./puntuacion.component.scss']
})
export class PuntuacionComponent implements OnInit {
  idPuntuacion: number = 0; idAtleta: number = 0; puntajeJuez1: number = 0; puntajeJuez2: number = 0;
  puntajeJuez3: number= 0; puntajeJuez4: number =0; puntajeJuez5: number = 0;

  constructor(private api: ApiService) { }

  ngOnInit(): void {
  }

  registrarPuntuacion(){
    const p: puntaje = {
      idPuntuacion : this.idPuntuacion,
      idAtleta : this.idAtleta,
      puntajeJuez1: this.puntajeJuez1,
      puntajeJuez2: this.puntajeJuez2,
      puntajeJuez3: this.puntajeJuez3,
      puntajeJuez4: this.puntajeJuez4,
      puntajeJuez5: this.puntajeJuez5,
    }
    this.api.registrarPuntuacion(p).subscribe(data => {
      console.log(p);

    })
  }

}
