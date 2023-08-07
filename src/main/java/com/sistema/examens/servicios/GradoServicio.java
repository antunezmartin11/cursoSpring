package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Grado;

import java.util.List;

public interface GradoServicio {
    public Grado guardarGrado(Grado grado) throws Exception;

    public List<Grado> listarGrado () throws Exception;


}
