import { Component, OnInit } from '@angular/core';
import {ApiService} from "../api.service";
import {AtletaDetalle} from "../interfaces";

@Component({
  selector: 'app-atleta-detalle',
  templateUrl: './atleta-detalle.component.html',
  styleUrls: ['./atleta-detalle.component.scss']
})
export class AtletaDetalleComponent implements OnInit {
  lista: AtletaDetalle[] = [];
  constructor(private api: ApiService) { }

  ngOnInit(): void {
    this.api.obtenerPuntajePromedio().subscribe(data => {
      this.lista = data.lista;
    })
  }

}
