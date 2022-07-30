package uni.edu.pe.finalback.dao;

import uni.edu.pe.finalback.dto.Atleta;
import uni.edu.pe.finalback.dto.AtletaDetalle;
import uni.edu.pe.finalback.dto.Puntacion;

import java.util.List;

public interface GimnasiaDao {
    int registrarPuntuacion(Puntacion puntacion);
    int actualizarFlagsAtleta(Atleta atleta);

    List<AtletaDetalle> obtenerPuntajePromedio();

    List<Puntacion> obtenerPuntuaciones();
}
