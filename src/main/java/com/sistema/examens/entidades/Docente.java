package com.sistema.examens.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class Docente  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocente;

    private String codDocente;

    private boolean estado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona_docente", referencedColumnName = "idPersona")
    private Persona persona;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idArea_docente", referencedColumnName = "idArea")
    private Area area;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idTipoContrato_docente", referencedColumnName = "idTipoContrato")
    private TipoContrato tipoContrato;



}
