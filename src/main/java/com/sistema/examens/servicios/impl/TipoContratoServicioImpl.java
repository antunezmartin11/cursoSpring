package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.TipoContrato;
import com.sistema.examens.excepciones.UsuarioFoundException;
import com.sistema.examens.repositorios.TipoContratoRepository;
import com.sistema.examens.servicios.TipoContratoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoContratoServicioImpl implements TipoContratoServicio {

    @Autowired
    TipoContratoRepository tipoContratoRepository;

    public TipoContrato guardar(TipoContrato tipoContrato) throws Exception{

        TipoContrato verificarExiste = tipoContratoRepository.findByDescripcion(tipoContrato.getDescripcion());
        if(verificarExiste==null){
            TipoContrato nuevo= new TipoContrato();
            nuevo = tipoContrato;
            nuevo = tipoContratoRepository.save(nuevo);
            return nuevo;
        }else{
            throw new UsuarioFoundException("Tipo de contrato ya registrado");
        }

    }

    public List<TipoContrato> listaTipoContrato() throws Exception{
        List<TipoContrato> lista = tipoContratoRepository.findAll();
        if(lista.size()>0){
            return lista;
        }else {
            return new ArrayList<>();
        }

    }

    public TipoContrato obtenerTipoContrato(String nombre) throws Exception{
        TipoContrato obtener = tipoContratoRepository.findByDescripcion(nombre);
        if(obtener!=null){
            return obtener;
        }else return new TipoContrato();
    }
}
