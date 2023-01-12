package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
