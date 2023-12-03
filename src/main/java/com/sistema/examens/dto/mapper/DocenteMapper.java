package com.sistema.examens.dto.mapper;

import com.sistema.examens.dto.docenteDTO;
import com.sistema.examens.entidades.Docente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocenteMapper {

    DocenteMapper mapper = Mappers.getMapper(DocenteMapper.class);

    docenteDTO convertirDocenteToDocenteDTO(Docente docente);

    Docente convertirDocenteDTOToDocente(docenteDTO docenteDTO);
}
