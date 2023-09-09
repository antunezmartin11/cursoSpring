package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Seccion;
import com.sistema.examens.entidades.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepositorio extends JpaRepository<TipoUsuario,Long> {
    public TipoUsuario findByTipo(String nombre);

}
