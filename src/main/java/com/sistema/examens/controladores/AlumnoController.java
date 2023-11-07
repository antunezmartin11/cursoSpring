package com.sistema.examens.controladores;

import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Alumno;
import com.sistema.examens.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@CrossOrigin("*")
public class AlumnoController {

    @Autowired
    private AlumnoServicio alumnoServicio;

    @PostMapping("/")
    public Alumno guardarAlumno(@RequestBody Alumno alumno) throws Exception{
        Alumno nuevoAlumno = new Alumno();

        nuevoAlumno = alumnoServicio.guardarAlumno(alumno);
        if(nuevoAlumno!=null){
            return nuevoAlumno;
        }else {

            System.out.println("Ocurrio un error");
            return new Alumno();
        }
    }

    @GetMapping("/listarAlumno")
    public respuestaDTO listar() throws Exception{
        List<Alumno> alumnos = alumnoServicio.listarAlumno();
        respuestaDTO respuesta = new respuestaDTO();
        if(alumnos.size()>0){
            respuesta.setCodigo("200");
            respuesta.setData(alumnos);
            respuesta.setMensaje("Registrado correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(alumnos);
            respuesta.setMensaje("Ocurrio un error");


        }
        return respuesta;
    }
}
