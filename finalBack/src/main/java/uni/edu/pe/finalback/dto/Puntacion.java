package uni.edu.pe.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Puntacion {
    private int idPuntuacion, idAtleta, puntajeJuez1, puntajeJuez2,
            puntajeJuez3, puntajeJuez4, puntajeJuez5;
}
