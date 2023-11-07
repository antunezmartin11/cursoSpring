package com.sistema.examens.controladores;

import com.sistema.examens.dto.docenteDTO;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.servicios.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
@CrossOrigin("*")
public class DocenteController {

    @Autowired
    DocenteServicio docenteServicio;

    @PostMapping("/")
    public respuestaDTO guardar(@RequestBody docenteDTO request) throws Exception{
        docenteDTO registro = docenteServicio.guardar(request);
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

    @GetMapping("/listarDocente")
    public respuestaDTO listar() throws Exception{
        List<docenteDTO> listaDTO = docenteServicio.listar();
        respuestaDTO respuesta = new respuestaDTO();
        if(listaDTO!=null){
            respuesta.setCodigo("200");
            respuesta.setData(listaDTO);
            respuesta.setMensaje("Registros recuperados correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(listaDTO);
            respuesta.setMensaje("ocurrio un eror");
        }
        return respuesta;
    }
}
