export interface atleta {
  idAtleta: number,
  flgCondicionMedica: number,
  flgSustanciaProhibida: number
}

export interface puntaje {
  idPuntuacion: number, idAtleta: number, puntajeJuez1: number, puntajeJuez2: number,
  puntajeJuez3: number, puntajeJuez4: number, puntajeJuez5: number
}
export interface AtletaDetalle{
  nombre: String,
  talla: number, peso: number, flg_condicion_medica: number, flg_sustancia_prohibida: number, codigoPais: string, nombrePais: string, puntajePromedio: number
}
export interface RespuestaAtletaDetalle{
  lista: AtletaDetalle[]
}
