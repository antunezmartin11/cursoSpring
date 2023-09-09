package com.sistema.examens.dto;

import com.sistema.examens.entidades.Persona;
import com.sistema.examens.entidades.Rol;
import com.sistema.examens.entidades.UsuarioRol;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class usuarioDTO {

    private Long id;

    private String username;
    private String password;
    private boolean enabled=true;
    private String perfil;

    private Rol rol;
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    private Persona persona;
}
