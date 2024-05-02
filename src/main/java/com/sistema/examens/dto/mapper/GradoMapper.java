package com.sistema.examens.dto.mapper;

import com.sistema.examens.dto.gradoDTO;
import com.sistema.examens.entidades.Grado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GradoMapper {

    GradoMapper mapper = Mappers.getMapper(GradoMapper.class);
    @Mappings({
            @Mapping(target = "estado", expression = "java(grado.isEnabled() ? \"Activa\" : \"Inactiva\")")
    })
    gradoDTO convertirGradoToGradoDTO(Grado grado);
    @Mappings({
            @Mapping(target = "enabled", expression = "java(\"Activa\".equals(gradoDTO.getEstado()))")
    })
    Grado convertirGradoDTOtoGrado(gradoDTO gradoDTO);
}
