package uni.edu.pe.finalback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pais {
    private int idPais;
    private String codigo, nombre;
}
