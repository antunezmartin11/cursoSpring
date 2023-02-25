package com.sistema.examens.controladores;

import com.sistema.examens.entidades.Grado;
import com.sistema.examens.servicios.GradoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grado")
@CrossOrigin("*")
public class GradoController {

@Autowired
private GradoServicio gradoServicio;

@PostMapping("/RegistroGrado")
public Grado guardarGrado(@RequestBody Grado grado) throws Exception{
    grado.setNombre(grado.getNombre());
    return  gradoServicio.guardarGrado(grado);
}
}
