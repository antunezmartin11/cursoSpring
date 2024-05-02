package com.sistema.examens.servicios;

import com.sistema.examens.dto.areaDTO;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Area;

import java.util.List;

public interface AreaServicio {

    public respuestaDTO guardar(areaDTO area) throws Exception;

    public respuestaDTO obtenerxNombre(String nombre) throws Exception;

    public List<areaDTO> listarArea() throws Exception;

    public respuestaDTO actualizarArea(Long id, areaDTO request) throws Exception;
}
