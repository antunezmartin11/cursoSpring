package com.sistema.examens.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class seccionDTO {

    private Long idSeccion;

    private String nombre;

    private String estado;

    private String abreviatura;
}
