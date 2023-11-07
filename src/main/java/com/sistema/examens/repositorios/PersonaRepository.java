package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Persona;
import com.sistema.examens.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    public Persona findBydni(String dni);

    public Long countBydni(String dni);
}
