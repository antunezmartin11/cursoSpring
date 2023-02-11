package com.sistema.examens.entidades;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    private Long idAlumno;

    private String dni;

    private Date fechaNacimiento;

    private Character situacion;



}
