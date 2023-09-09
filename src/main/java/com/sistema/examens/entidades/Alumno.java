package com.sistema.examens.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    private String codAlumno;

    private boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona_alumno", referencedColumnName = "idPersona")
    private Persona persona;

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "id_seccion", referencedColumnName = "idSeccion")
    private Seccion seccion;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_grado", referencedColumnName = "id")
    private Grado grado;



}
