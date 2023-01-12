package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Usuario;
import com.sistema.examens.entidades.UsuarioRol;

import java.util.Set;

public interface UsuarioServicio {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws  Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
