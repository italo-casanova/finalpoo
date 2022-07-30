package uni.edu.pe.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Atleta {
    private int idAtleta, talla, flgCondicionMedica, flgSustanciaProhibida, idPais;
    private double peso;
    private String nombres;
}
