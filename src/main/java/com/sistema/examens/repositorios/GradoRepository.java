package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoRepository extends JpaRepository<Grado, Long> {

    public Grado findByNombre(String nombre);

}
