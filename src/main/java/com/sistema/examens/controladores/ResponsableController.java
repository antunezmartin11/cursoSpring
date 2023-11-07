package com.sistema.examens.controladores;

import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Responsable;
import com.sistema.examens.repositorios.AlumnoRepository;
import com.sistema.examens.servicios.ResponsableServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsable")
@CrossOrigin("*")
public class ResponsableController {
    @Autowired
    ResponsableServicio responsableServicio;

    @Autowired
    AlumnoRepository alumnoRepository;

    @PostMapping("/")
    public respuestaDTO guardar(@RequestBody Responsable responsable) throws Exception{
        respuestaDTO respuesta = new respuestaDTO();
        Long validarAlumno = alumnoRepository.cantidadAlumono(responsable.getPersona().getDni());
        Responsable responsableV = new Responsable();
        responsableV=responsableServicio.guardar(responsable);
        respuesta.setData(responsableV);

        return respuesta;
    }

}
