package com.sistema.examens.servicios;

import com.sistema.examens.dto.docenteDTO;


import java.util.List;

public interface DocenteServicio {
    public docenteDTO guardar (docenteDTO docenteDTO) throws Exception;

    public List<docenteDTO> listar () throws Exception;
}
