package com.sistema.examens;

import com.sistema.examens.entidades.Rol;
import com.sistema.examens.entidades.Usuario;
import com.sistema.examens.entidades.UsuarioRol;
import com.sistema.examens.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenBackendApplication implements CommandLineRunner {

    @Autowired
    private UsuarioServicio usuarioServicio;

    public static void main(String[] args) {
        SpringApplication.run(SistemaExamenBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Usuario usuario = new Usuario();
////        usuario.setNombre("Yoel");
////        usuario.setApellidos("Antunez");
//        usuario.setUsername("mantunez");
//        usuario.setPassword("123456");
////        usuario.setEmail("antunezomartin@outlook.com");
////        usuario.setTelefono("9403063627");
//        usuario.setPerfil("foto.png");
//
//        Rol rol = new Rol();
//        rol.setRolId(1L);
//        rol.setNombre("ADMIN");
//
//        Set<UsuarioRol> usuarioRoles = new HashSet<>();
//        UsuarioRol usuarioRol = new UsuarioRol();
//        usuarioRol.setRol(rol);
//        usuarioRol.setUsuario(usuario);
//        usuarioRoles.add(usuarioRol);
//
//        Usuario usuarioGuardado = usuarioServicio.guardarUsuario(usuario, usuarioRoles);
//        System.out.println(usuarioGuardado.getUsername());
    }
}
