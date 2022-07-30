package uni.edu.pe.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AtletaDetalle {
    private String nombres, codigoPais, nombrePais;
    private int  talla, flgCondicionMedica, flgSustanciaProhibida, puntajePromedio;
    private double peso;

}
