package com.sistema.examens.controladores;

import com.sistema.examens.entidades.Rol;
import com.sistema.examens.entidades.Usuario;
import com.sistema.examens.entidades.UsuarioRol;
import com.sistema.examens.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        UsuarioRol usuarioRol= new UsuarioRol();
        for (UsuarioRol usuarioRole: usuario.getUsuarioRoles() ){
            if(usuarioRole.getRol()!=null){
                usuarioRol.setRol(usuarioRole.getRol());
                usuarioRol.setUsuario(usuario);
            }

        }

        //Rol  rol = new Rol();
        //rol.setRolId(2L);
        //rol.setNombre("NORMAL");
        usuarioRoles.add(usuarioRol);
        return usuarioServicio.guardarUsuario(usuario, usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){

        Usuario datUsuario = usuarioServicio.obtenerUsuario(username);

        if (datUsuario != null){
            return datUsuario;
        }else{
            return new Usuario();
        }
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioServicio.eliminarUsuario(usuarioId);
    }
}
