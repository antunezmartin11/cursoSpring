package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Alumno;
import com.sistema.examens.entidades.Persona;
import com.sistema.examens.entidades.Responsable;
import com.sistema.examens.repositorios.AlumnoRepository;
import com.sistema.examens.repositorios.PersonaRepository;
import com.sistema.examens.repositorios.ResponsableRepositorio;
import com.sistema.examens.servicios.ResponsableServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponsableServiceImpl implements ResponsableServicio {

    @Autowired
    ResponsableRepositorio responsableRepositorio;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    public List<Responsable> listarResponsable() throws Exception{
        List<Responsable> lista = responsableRepositorio.findAll();
        if(lista.size()>0){
            return  lista;
        }else
            return new ArrayList<Responsable>();
    }

    public Responsable guardar(Responsable request) throws Exception{
        Persona verificarPersona = new Persona();
        Long verificarAlumno = alumnoRepository.cantidadAlumono(request.getPersona().getDni());

        Long cantidadRegPer = personaRepository.countBydni(request.getPersona().getDni());

        Responsable res = new Responsable();

        return res;
    }

}
