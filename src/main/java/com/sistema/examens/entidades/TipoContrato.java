package com.sistema.examens.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tipo_contrato")
public class TipoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoContrato;

    private String descripcion;

    private boolean estado;
}
