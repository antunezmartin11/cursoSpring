package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepositorio extends JpaRepository<Area, Long> {

    public Area findByNombre(String nombre);
}
