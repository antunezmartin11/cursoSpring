package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Persona;

import java.util.List;

public interface PersonaServicio {

    public Persona guardarPersona(Persona persona) throws  Exception;

    public List<Persona> listarPersonas() throws Exception;

    public Persona personaDNI (String DNI) throws  Exception;
}
