package com.sistema.examens.entidades;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tipoPersona")
public class tipoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPersona;

    private String tipo;

    private boolean enabled;

    @OneToMany(mappedBy = "tipoPersona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Persona> persona;



    public Long getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Long idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Persona> getPersona() {
        return persona;
    }

    public void setPersona(Set<Persona> persona) {
        this.persona = persona;
    }

    public tipoPersona() {
    }
}
