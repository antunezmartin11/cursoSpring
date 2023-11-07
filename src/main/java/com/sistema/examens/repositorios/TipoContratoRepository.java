package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContratoRepository extends JpaRepository<TipoContrato, Long> {

    public TipoContrato findByDescripcion(String nombre);
}
