package com.sistema.examens.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "admnistrativo")
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmnistrativo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona" )
    private Persona persona;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idTipoContrato", referencedColumnName = "idTipoContrato")
    private TipoContrato tipoContrato;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCargoAdministrativo", referencedColumnName = "idCargoAdministrativo")
    private CargoAdministrativo cargoAdministrativo;

    private boolean estado;
}
