package com.sistema.examens.controladores;

import com.sistema.examens.entidades.TipoUsuario;
import com.sistema.examens.servicios.TipoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoUsuario")
@CrossOrigin("*")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioServicio tipoUsuarioServicio;

    @PostMapping("/RegistroTipoUsuario")
    public TipoUsuario guardarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) throws Exception{
        if(tipoUsuario !=null){
            return tipoUsuarioServicio.guardarTipoUsuario(tipoUsuario);
        }else{
             TipoUsuario  tp = new TipoUsuario();
             return tp;
        }
    }

    @GetMapping("/listarTipoUsuario")
    public List<TipoUsuario> listarTipoUsuario()throws Exception{
        return tipoUsuarioServicio.listarTipoUsuario();
    }
}
