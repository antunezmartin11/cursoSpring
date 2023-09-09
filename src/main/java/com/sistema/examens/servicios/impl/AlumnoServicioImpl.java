package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Alumno;
import com.sistema.examens.entidades.Persona;
import com.sistema.examens.repositorios.AlumnoRepository;
import com.sistema.examens.repositorios.PersonaRepository;
import com.sistema.examens.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServicioImpl implements AlumnoServicio {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Alumno guardarAlumno(Alumno alumno) throws Exception {
        Persona obtenerPersona = personaRepository.findBydni(alumno.getPersona().getDni());
        Alumno alumnoRegistro = new Alumno();
        if(obtenerPersona != null){
            alumnoRegistro.setPersona(obtenerPersona);
        }else {
            alumnoRegistro.setPersona(alumno.getPersona());
        }
        alumnoRegistro.setCodAlumno(alumno.getCodAlumno());
        alumnoRegistro.setEstado(alumno.isEstado());
        alumnoRegistro.setSeccion(alumno.getSeccion());
        alumnoRegistro.setGrado(alumno.getGrado());

        Alumno alumnoRegistrado = alumnoRepository.save(alumnoRegistro);

        return alumnoRegistrado;
    }
}
