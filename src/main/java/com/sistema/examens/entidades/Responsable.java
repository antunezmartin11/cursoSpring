package com.sistema.examens.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "responsable")
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsable;

    private String parentesco;


    private String codigo;

    private boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona persona;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno")
    private Alumno alumno;


}
