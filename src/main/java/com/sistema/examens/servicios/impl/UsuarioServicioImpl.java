package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Usuario;
import com.sistema.examens.entidades.UsuarioRol;
import com.sistema.examens.excepciones.UsuarioFoundException;
import com.sistema.examens.repositorios.RolRepositorio;
import com.sistema.examens.repositorios.UsuarioRepositorio;
import com.sistema.examens.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepositorio.findByUsername(usuario.getUsername());
        if(usuarioLocal !=null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }else{
            for (UsuarioRol usuarioRol: usuarioRoles){
                rolRepositorio.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepositorio.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepositorio.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
    }
}
