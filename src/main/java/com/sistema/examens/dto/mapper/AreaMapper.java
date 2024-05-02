package com.sistema.examens.dto.mapper;

import com.sistema.examens.dto.areaDTO;
import com.sistema.examens.entidades.Area;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AreaMapper  {
    AreaMapper mapper = Mappers.getMapper(AreaMapper.class);

    areaDTO convertirAreaToAreaDTO(Area area);

    Area converitirDTOToArea(areaDTO areaDTO);

}
