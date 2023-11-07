package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Administrativo;
import com.sistema.examens.entidades.Persona;
import com.sistema.examens.excepciones.UsuarioFoundException;
import com.sistema.examens.repositorios.AdministrativoRepositorio;
import com.sistema.examens.repositorios.PersonaRepository;
import com.sistema.examens.servicios.AdministrativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrativoServiceImpl implements AdministrativoServicio {

    @Autowired
    AdministrativoRepositorio administrativoRepositorio;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Administrativo guardar(Administrativo request) throws Exception{
        Administrativo registro = new Administrativo();
        if(request!=null){
            Persona verificarPersona = personaRepository.findBydni(request.getPersona().getDni());

            if(verificarPersona!=null){
                registro.setPersona(verificarPersona);
            }else {
                registro.setPersona(request.getPersona());
            }
            registro.setCargoAdministrativo(request.getCargoAdministrativo());
            registro.setTipoContrato(request.getTipoContrato());
            registro.setEstado(true);

            registro = administrativoRepositorio.save(registro);
        }

        return registro;
    }

    @Override
    public  Administrativo obtener(Administrativo request) throws Exception{

        //Buscar persona
        Persona buscarPersona = personaRepository.findBydni(request.getPersona().getDni());
        if(buscarPersona!=null){
            //Buscar administrativo
            Administrativo buscarAdministrativo = administrativoRepositorio.findByPersona(buscarPersona);
            if(buscarAdministrativo!=null){
                return buscarAdministrativo;
            }else {
                throw new UsuarioFoundException("No se encontro registro");
            }
        }else {
            throw new UsuarioFoundException("No se encontro registro");
        }
    }

}
