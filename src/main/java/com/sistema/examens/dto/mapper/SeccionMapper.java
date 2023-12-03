package com.sistema.examens.dto.mapper;

import com.sistema.examens.dto.seccionDTO;
import com.sistema.examens.entidades.Seccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeccionMapper {

    SeccionMapper mapper = Mappers.getMapper(SeccionMapper.class);

    @Mappings({
            @Mapping(target = "estado", expression = "java(seccion.isEnabled() ? \"Activa\" : \"Inactiva\")")
    })
    seccionDTO convertirSeccionToSeccionDTO(Seccion seccion);

    Seccion convertirSeccionDTOToSeccion(seccionDTO seccionDTO);

}
