package com.sistema.examens.controladores;

import com.sistema.examens.entidades.Seccion;
import com.sistema.examens.servicios.SeccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seccion")
@CrossOrigin("*")
public class SeccionController {

@Autowired
private SeccionServicio seccionServicio;

@PostMapping("/Registro-seccion")
public Seccion guardarSeccion(@RequestBody Seccion seccion) throws Exception{
    seccion.setNombre(seccion.getNombre());
    return seccionServicio.guardarSeccion(seccion);
}

}

