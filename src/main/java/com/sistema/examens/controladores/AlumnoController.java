package com.sistema.examens.controladores;

import com.sistema.examens.entidades.Alumno;
import com.sistema.examens.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
