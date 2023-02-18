package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Seccion;
import com.sistema.examens.repositorios.SeccionRepository;
import com.sistema.examens.servicios.SeccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionServicioImpl implements SeccionServicio {

    @Autowired
    private SeccionRepository seccionRepositorio;

    @Override
    public Seccion guardarSeccion(Seccion seccion) throws Exception{
        Seccion seccionNueva = seccionRepositorio.findByNombre(seccion.getNombre());
        if(seccionNueva !=null){
            System.out.println("Seccion ya existe");
        }else{
            seccionNueva = seccionRepositorio.save(seccion);
        }
        return seccionNueva;
    }


}
