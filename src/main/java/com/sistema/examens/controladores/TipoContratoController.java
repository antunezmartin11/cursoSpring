package com.sistema.examens.controladores;

import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.TipoContrato;
import com.sistema.examens.servicios.TipoContratoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoContrato")
@CrossOrigin("*")
public class TipoContratoController {
    @Autowired
    private TipoContratoServicio tipoContratoServicio;

    @PostMapping("/")
    public respuestaDTO guardar(@RequestBody TipoContrato request) throws Exception{
        TipoContrato registro = tipoContratoServicio.guardar(request);
        respuestaDTO respuesta = new respuestaDTO();
        if(registro!=null){
            respuesta.setCodigo("200");
            respuesta.setData(registro);
            respuesta.setMensaje("Registrado correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(new TipoContrato());
            respuesta.setMensaje("Ocurrio un error");
        }

        return respuesta;

    }
}
