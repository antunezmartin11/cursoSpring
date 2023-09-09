package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.TipoUsuario;
import com.sistema.examens.repositorios.TipoUsuarioRepositorio;
import com.sistema.examens.servicios.TipoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoUsuarioServicioImpl implements TipoUsuarioServicio {

    @Autowired
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;

    @Override
    public TipoUsuario guardarTipoUsuario (TipoUsuario tipoUsuario) throws Exception{
        TipoUsuario tipoNuevo = tipoUsuarioRepositorio.findByTipo(tipoUsuario.getTipo());
        if(tipoNuevo !=null){
            System.out.println("Seccion ya existe");
            return tipoNuevo;
        }else{
            TipoUsuario tu = tipoUsuarioRepositorio.save(tipoUsuario);
            return tu;
        }
    }

    @Override
    public List<TipoUsuario> listarTipoUsuario () throws Exception{
        List<TipoUsuario> lista = tipoUsuarioRepositorio.findAll();
        if(lista.size()>0){
            return lista;
        }else {
            return new ArrayList<>();
        }
    }
}
