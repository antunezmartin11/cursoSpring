package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Persona;
import com.sistema.examens.entidades.TipoUsuario;
import com.sistema.examens.entidades.Usuario;
import com.sistema.examens.entidades.UsuarioRol;
import com.sistema.examens.excepciones.UsuarioFoundException;
import com.sistema.examens.repositorios.PersonaRepository;
import com.sistema.examens.repositorios.RolRepositorio;
import com.sistema.examens.repositorios.TipoUsuarioRepositorio;
import com.sistema.examens.repositorios.UsuarioRepositorio;
import com.sistema.examens.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;
    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        //Validar Persona
        Usuario u = new Usuario();
        Usuario usuarioLocal = usuarioRepositorio.findByUsername(usuario.getUsername());
        if(usuarioLocal !=null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }else{
            for (UsuarioRol usuarioRol: usuarioRoles){
                rolRepositorio.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);

            Persona datosPersona = personaRepository.findBydni(usuario.getPersona().getDni());

            if(datosPersona!=null){//Si existe la persona carga los datos

                u.setPersona(datosPersona);
            }else {//Si no existe realiza el registro de persona
                Persona personaNueva= personaRepository.save(usuario.getPersona());
                u.setPersona(personaNueva);
            }


            u.setEnabled(usuario.isEnabled());
            u.setPassword(usuario.getPassword());
            u.setUsername(usuario.getUsername());
            u.setPerfil(usuario.getPerfil());
            u = usuarioRepositorio.save(usuario);
            System.out.println("Se registro el usuario");
            return u;
        }
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
