package com.sistema.examens.entidades;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    private Long idPersona;

    private String dni;

    private String apellido;
    private String nombre;

    private String email;

    private Integer telefono;
    private Date fechaNacimiento;

    private Character situacion;





    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSituacion() {
        return situacion;
    }

    public void setSituacion(Character situacion) {
        this.situacion = situacion;
    }


    public Persona() {
    }
}
