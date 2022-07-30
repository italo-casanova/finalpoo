package uni.edu.pe.finalback.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import uni.edu.pe.finalback.dto.AtletaDetalle;

import java.util.List;

@Data
@AllArgsConstructor
public class RuestaPromedioOrdenada {
    List<AtletaDetalle> RespuestaOrdenada;
}
