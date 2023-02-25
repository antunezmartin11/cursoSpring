package com.sistema.examens.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "seccion")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeccion;

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    private boolean enabled=true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

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
