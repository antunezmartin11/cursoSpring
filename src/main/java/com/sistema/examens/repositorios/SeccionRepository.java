package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Seccion;
import com.sistema.examens.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository extends JpaRepository<Seccion, Long> {
    public Seccion findByNombre(String nombre);
}
