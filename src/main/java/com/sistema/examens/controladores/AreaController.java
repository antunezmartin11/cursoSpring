package com.sistema.examens.controladores;

import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Area;
import com.sistema.examens.servicios.AreaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@CrossOrigin("*")
public class AreaController {

    @Autowired
    AreaServicio areaServicio;

    @PostMapping("/")
    public respuestaDTO guardar(@RequestBody Area request) throws Exception{
        Area registro = areaServicio.guardar(request);
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

    @GetMapping("/listarArea")
    public respuestaDTO listar() throws Exception{
        List<Area> lista = areaServicio.listarArea();
        respuestaDTO respuesta = new respuestaDTO();
        if (lista!=null){
            respuesta.setCodigo("200");
            respuesta.setData(lista);
            respuesta.setMensaje("Registrado correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(lista);
            respuesta.setMensaje("Ocurrio un error");
        }

        return respuesta;
    }

    @GetMapping("/obtenerXnombre")
    public respuestaDTO obtener(@RequestBody Area area) throws Exception{
        Area registro = areaServicio.obtenerxNombre(area.getNombre());
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
