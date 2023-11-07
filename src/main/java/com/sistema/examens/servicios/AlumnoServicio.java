package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Alumno;

import java.util.List;

public interface AlumnoServicio {

    public Alumno guardarAlumno (Alumno alumno) throws Exception;

    public List<Alumno> listarAlumno () throws Exception;
}
