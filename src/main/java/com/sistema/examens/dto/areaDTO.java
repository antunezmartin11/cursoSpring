package com.sistema.examens.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class areaDTO {
    private Long idArea;

    private String nombre;

    private BigDecimal horas;

    private boolean estado;
}
