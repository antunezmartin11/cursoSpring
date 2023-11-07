package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Administrativo;
import com.sistema.examens.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativoRepositorio extends JpaRepository<Administrativo, Long> {

    public Administrativo findByPersona(Persona persona);
}
