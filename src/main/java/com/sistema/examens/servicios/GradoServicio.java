package com.sistema.examens.servicios;

import com.sistema.examens.dto.gradoDTO;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Grado;

import java.util.List;

public interface GradoServicio {
    public respuestaDTO guardarGrado(gradoDTO grado) throws Exception;

    public List<gradoDTO> listarGrado () throws Exception;

    public respuestaDTO editarGrado(gradoDTO grado) throws Exception;

    public respuestaDTO eliminarGrado(Long id) throws Exception;


}
