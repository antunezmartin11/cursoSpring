package com.sistema.examens.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "cargo_administrativo")
public class CargoAdministrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargoAdministrativo;

    private String descripcion;

    private boolean estado;

}
