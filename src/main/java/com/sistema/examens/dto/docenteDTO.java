package com.sistema.examens.dto;

import com.sistema.examens.entidades.Area;
import com.sistema.examens.entidades.Persona;
import com.sistema.examens.entidades.TipoContrato;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class docenteDTO {
    private Long idDocente;

    private String codDocente;
    private boolean estado;

    private Persona persona;

    private Area area;

    private TipoContrato tipoContrato;

}
