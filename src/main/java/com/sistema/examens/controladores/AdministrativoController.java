package com.sistema.examens.controladores;

import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Administrativo;
import com.sistema.examens.entidades.TipoContrato;
import com.sistema.examens.servicios.AdministrativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrativo")
@CrossOrigin("*")
public class AdministrativoController {
    @Autowired
    AdministrativoServicio administrativoServicio;

    @PostMapping("/")
    public respuestaDTO guardar(@RequestBody Administrativo request) throws Exception{
        Administrativo registro = administrativoServicio.guardar(request);
        respuestaDTO respuesta = new respuestaDTO();

        if(registro!=null){
            respuesta.setCodigo("200");
            respuesta.setData(registro);
            respuesta.setMensaje("Registrado correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(registro);
            respuesta.setMensaje("Ocurrio un error");
        }

        return respuesta;
    }

    @GetMapping("/obtener")
    public respuestaDTO obtener(@RequestBody Administrativo request) throws Exception{
        Administrativo registro = administrativoServicio.obtener(request);
        respuestaDTO respuesta = new respuestaDTO();
        if(registro!=null){
            respuesta.setCodigo("200");
            respuesta.setData(registro);
            respuesta.setMensaje("Registrado correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(registro);
            respuesta.setMensaje("Ocurrio un error");
        }

        return respuesta;
    }
}
