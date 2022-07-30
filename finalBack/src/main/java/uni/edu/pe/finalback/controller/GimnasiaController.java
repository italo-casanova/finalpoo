package uni.edu.pe.finalback.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.finalback.dto.Atleta;
import uni.edu.pe.finalback.dto.Puntacion;
import uni.edu.pe.finalback.dto.rest.RuestaPromedioOrdenada;
import uni.edu.pe.finalback.service.GimnasiaService;

@RestController
public class GimnasiaController {
    @Autowired
    GimnasiaService service;


    @ResponseBody
    @RequestMapping(
            value = "/registrarPuntuacion",
            method = RequestMethod.POST
    )
    Puntacion registrarPuntuacion(@RequestBody Puntacion puntacion) {
       service.registrarPuntuacion(puntacion);
       return puntacion;
    }

    @ResponseBody
    @RequestMapping(
            value = "/actualizarFlagsAtleta",
            method = RequestMethod.POST
    )
    Atleta actualizarFlagsAtleta(@RequestBody Atleta atleta) {
        service.actualizarFlagsAtleta(atleta);
        return atleta;

    }

    @ResponseBody
    @RequestMapping(
            value = "/obtenerPromedio",
            method = RequestMethod.POST
    )
    RuestaPromedioOrdenada obtenerPuntajePromedio(){
        return new RuestaPromedioOrdenada(service.obtenerPuntajePromedio());
    }

}
