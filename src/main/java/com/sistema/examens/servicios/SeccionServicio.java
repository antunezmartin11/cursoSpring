package com.sistema.examens.servicios;

import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.dto.seccionDTO;
import com.sistema.examens.entidades.Seccion;

import java.util.List;

public interface SeccionServicio {

    public respuestaDTO guardarSeccion(seccionDTO seccion) throws  Exception;

    public List<seccionDTO> listar() throws Exception;
}
