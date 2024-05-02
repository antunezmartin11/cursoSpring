package com.sistema.examens.controladores;

import com.sistema.examens.dto.gradoDTO;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Grado;
import com.sistema.examens.servicios.GradoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grado")
@CrossOrigin("*")
public class GradoController {

@Autowired
private GradoServicio gradoServicio;

    @PostMapping("/RegistroGrado")
    public respuestaDTO guardarGrado(@RequestBody gradoDTO grado) throws Exception{
    grado.setNombre(grado.getNombre());
    return  gradoServicio.guardarGrado(grado);
}

    @GetMapping("/getAll")
    public respuestaDTO getGrado() throws Exception{

        respuestaDTO respuesta = new respuestaDTO();
        List<gradoDTO> listaGrado =  gradoServicio.listarGrado();
        if(listaGrado!=null){
            respuesta.setCodigo("200");
            respuesta.setData(listaGrado);
            respuesta.setMensaje("Registros recuperados correctamente");
        }else {
            respuesta.setCodigo("500");
            respuesta.setData(listaGrado);
            respuesta.setMensaje("ocurrio un error");
        }
        return respuesta;
    }

    @PostMapping("/updateGrado")
    public respuestaDTO actualizarGrado(@RequestBody gradoDTO request) throws Exception{
        return gradoServicio.editarGrado(request);
    }

    @DeleteMapping("/eliminarGrado/{id}")
    public respuestaDTO eliminarGrado(@PathVariable Long id) throws Exception{
        return gradoServicio.eliminarGrado(id);
    }
}
