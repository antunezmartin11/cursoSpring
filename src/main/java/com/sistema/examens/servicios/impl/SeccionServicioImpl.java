package com.sistema.examens.servicios.impl;

import com.sistema.examens.dto.docenteDTO;
import com.sistema.examens.dto.mapper.DocenteMapper;
import com.sistema.examens.dto.mapper.SeccionMapper;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.dto.seccionDTO;
import com.sistema.examens.entidades.Docente;
import com.sistema.examens.entidades.Seccion;
import com.sistema.examens.repositorios.SeccionRepository;
import com.sistema.examens.servicios.SeccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeccionServicioImpl implements SeccionServicio {

    @Autowired
    private SeccionRepository seccionRepositorio;

    @Override
    public respuestaDTO guardarSeccion(seccionDTO seccion) throws Exception{
        Seccion seccionNueva = seccionRepositorio.findByNombre(seccion.getNombre());
        respuestaDTO respuesta = new respuestaDTO();
        if(seccionNueva !=null){
            System.out.println("Seccion ya existe");
            seccionDTO seccionReg = SeccionMapper.mapper.convertirSeccionToSeccionDTO(seccionNueva);
            respuesta.setMensaje("Seccion ya existe");
            respuesta.setCodigo("200");
            respuesta.setData(seccionReg);
        }else{
            Seccion regSeccion= new Seccion();
            regSeccion = SeccionMapper.mapper.convertirSeccionDTOToSeccion(seccion);
            regSeccion = seccionRepositorio.save(regSeccion);
            //seccionNueva = seccionRepositorio.save(seccionDTO);
            seccionDTO seccionReg = SeccionMapper.mapper.convertirSeccionToSeccionDTO(regSeccion);
            respuesta.setMensaje("Seccion registrada");
            respuesta.setCodigo("200");
            respuesta.setData(seccionReg);
        }
        return  respuesta;
    }

    @Override
    public List<seccionDTO> listar() throws Exception {
        List<Seccion> lista = seccionRepositorio.findAll();

        List<seccionDTO> listaSeccion = lista.stream().map(
                list -> SeccionMapper.mapper.convertirSeccionToSeccionDTO(list)).collect(Collectors.toList());

        return listaSeccion;
    }


}
