package com.sistema.examens.servicios.impl;

import com.sistema.examens.dto.mapper.DocenteMapper;
import com.sistema.examens.dto.docenteDTO;
import com.sistema.examens.entidades.Docente;
import com.sistema.examens.repositorios.DocenteRepositorio;
import com.sistema.examens.servicios.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteServiceImpl implements DocenteServicio {

    @Autowired
    DocenteRepositorio  docenteRepositorio;

    @Override
    public docenteDTO guardar(docenteDTO request) throws Exception{

        Docente registroDoc = new Docente();

        registroDoc = DocenteMapper.mapper.convertirDocenteDTOToDocente(request);

        registroDoc = docenteRepositorio.save(registroDoc);

        docenteDTO docente = DocenteMapper.mapper.convertirDocenteToDocenteDTO(registroDoc);

        return docente;
    }

    @Override
    public List<docenteDTO> listar() throws Exception {
        List<Docente> lista = docenteRepositorio.findAll();

        List<docenteDTO> listaDocente = lista.stream().map(
                list -> DocenteMapper.mapper.convertirDocenteToDocenteDTO(list)).collect(Collectors.toList());

        return listaDocente;
    }

}
