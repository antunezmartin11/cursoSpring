package com.sistema.examens.controladores;

import com.sistema.examens.entidades.Persona;
import com.sistema.examens.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {
    @Autowired
    private PersonaServicio personaServicio;

    @PostMapping("/")
    public Persona guardarPersona(@RequestBody Persona persona) throws Exception{
        Persona verificarPersona = personaServicio.personaDNI(persona.getDni());
        if(verificarPersona.getDni()!=null){
            System.out.println("El usuario ya esta registrado");
            return verificarPersona;
        }else {
            Persona personaNueva = new Persona();
            personaNueva = persona;
            personaNueva = personaServicio.guardarPersona(personaNueva);

            return personaNueva;
        }
    }

    @GetMapping("/listaPersonas")
    public List<Persona> listarPersona() throws Exception{

        List<Persona> lista = personaServicio.listarPersonas();

        return lista;

    }

}
