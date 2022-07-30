package uni.edu.pe.finalback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.finalback.dao.GimnasiaDao;
import uni.edu.pe.finalback.dto.Atleta;
import uni.edu.pe.finalback.dto.AtletaDetalle;
import uni.edu.pe.finalback.dto.Puntacion;

import java.util.List;


@Service
public class GimnasiaServiceImp implements GimnasiaService {

    @Autowired
    GimnasiaDao dao;
    @Override
    public int registrarPuntuacion(Puntacion puntacion) {
        return dao.registrarPuntuacion(puntacion);
    }

    @Override
    public int actualizarFlagsAtleta(Atleta atleta) {
        return dao.actualizarFlagsAtleta(atleta);
    }

    @Override
    public List<AtletaDetalle> obtenerPuntajePromedio() {
        return dao.obtenerPuntajePromedio();
    }


    public List<Puntacion> obtenerPuntuaciones() {
        return dao.obtenerPuntuaciones();
    }
}
