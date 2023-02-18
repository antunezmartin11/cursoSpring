package com.sistema.examens.entidades;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "seccion")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeccion;

    private String nombre;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private Set<Grado> grado;

    public Long getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Long idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Grado> getGrado() {
        return grado;
    }

    public void setGrado(Set<Grado> grado) {
        this.grado = grado;
    }

    public Seccion() {
    }
}
