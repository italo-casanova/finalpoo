import { Component, OnInit } from '@angular/core';
import {ApiService} from "../api.service";
import {atleta, puntaje} from "../interfaces";
import {catchError, Observable, retry} from "rxjs";

@Component({
  selector: 'app-atleta',
  templateUrl: './atleta.component.html',
  styleUrls: ['./atleta.component.scss']
})
export class AtletaComponent implements OnInit {
  idAtleta: number = 0;
  flgCondicionMedica: number = 0;
  flgSustanciaProhibida: number = 0;

  constructor(private api: ApiService) { }
  actualizarFlagsAtleta(){
    const a: atleta = {
      idAtleta : this.idAtleta,
      flgCondicionMedica : this.flgCondicionMedica,
      flgSustanciaProhibida : this.flgSustanciaProhibida
  }
    this.api.actualizarFlagsAtleta(a).subscribe(data => {
      console.log(a);

    })
  }

  ngOnInit(): void {
  }

}
