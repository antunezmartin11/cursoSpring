package com.sistema.examens.controladores;

import com.sistema.examens.dto.docenteDTO;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.dto.seccionDTO;
import com.sistema.examens.entidades.Seccion;
import com.sistema.examens.servicios.SeccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seccion")
@CrossOrigin("*")
public class SeccionController {

@Autowired
private SeccionServicio seccionServicio;

    @PostMapping("/Registro-seccion")
    public respuestaDTO guardarSeccion(@RequestBody seccionDTO seccion) throws Exception{
        return seccionServicio.guardarSeccion(seccion);
    }

    @GetMapping("/listarSeccion")
    public respuestaDTO listar() throws Exception{
        List<seccionDTO> listaDTO = seccionServicio.listar();
        respuestaDTO respuesta = new respuestaDTO();
        if(listaDTO!=null){
            respuesta.setCodigo("200");
            respuesta.setData(listaDTO);
            respuesta.setMensaje("Registros recuperados correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(listaDTO);
            respuesta.setMensaje("ocurrio un error");
        }
        return respuesta;
    }

}

