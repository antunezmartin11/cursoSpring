package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Grado;
import com.sistema.examens.repositorios.GradoRepository;
import com.sistema.examens.servicios.GradoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradoServicioImpl implements GradoServicio {

    @Autowired
    private GradoRepository gradoRepository;

    @Override
    public Grado guardarGrado(Grado grado) throws Exception{
        Grado gradoNuevo = gradoRepository.findByNombre(grado.getNombre());
        if(gradoNuevo !=null){
            System.out.println("Seccion ya existe");
        }else{
            gradoNuevo = gradoRepository.save(grado);
        }
        return gradoNuevo;
    }

    @Override
    public List<Grado> listarGrado() throws Exception{
        List<Grado> lista = gradoRepository.findAll();
        if(lista.size()>0){
            return lista;
        }else {
            return new ArrayList<>();
        }

    }
}
