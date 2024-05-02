package com.sistema.examens.controladores;

import com.sistema.examens.dto.areaDTO;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Area;
import com.sistema.examens.servicios.AreaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@CrossOrigin("*")
public class AreaController {

    @Autowired
    AreaServicio areaServicio;

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public respuestaDTO guardar(@RequestBody areaDTO request) throws Exception{

        return areaServicio.guardar(request);
    }

    @GetMapping("/listarArea")
    public respuestaDTO listar() throws Exception{
        List<areaDTO> lista = areaServicio.listarArea();
        respuestaDTO respuesta = new respuestaDTO();
        if (lista!=null){
            respuesta.setCodigo(HttpStatus.OK.toString());
            respuesta.setData(lista);
            respuesta.setMensaje("Registros recuperados");
        }else {
            respuesta.setCodigo(String.valueOf(HttpStatus.FOUND));
            respuesta.setData(lista);
            respuesta.setMensaje("Ocurrio un error");
        }

        return respuesta;
    }

    @GetMapping("/obtenerXnombre")
    public respuestaDTO obtener(@RequestBody areaDTO area) throws Exception{
            return areaServicio.obtenerxNombre(area.getNombre());
    }

    @PostMapping("/modificarArea/{id}")
    public respuestaDTO modificar(@PathVariable Long id,  @RequestBody areaDTO area) throws Exception{
        return areaServicio.actualizarArea(id, area);
    }
}
