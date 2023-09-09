package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Persona;
import com.sistema.examens.repositorios.PersonaRepository;
import com.sistema.examens.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona guardarPersona(Persona persona) throws Exception{
        Persona personaNueva = personaRepository.findBydni(persona.getDni());
        if(personaNueva!=null){
            System.out.println("Seccion ya existe");
        }else {
            personaNueva = personaRepository.save(persona);
        }

        return personaNueva;
    }

    @Override
    public List<Persona> listarPersonas() throws Exception{
        List<Persona> lista = personaRepository.findAll();
        if(lista.size()>0){
            return lista;
        }else {
            return new ArrayList<>();
        }

    }
    @Override
    public Persona personaDNI(String DNI) throws Exception{
        Persona personDNI = personaRepository.findBydni(DNI);
        if(personDNI !=null){
            return personDNI;
        }else {
            return new Persona();
        }
    }

}
