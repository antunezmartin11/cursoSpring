package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
