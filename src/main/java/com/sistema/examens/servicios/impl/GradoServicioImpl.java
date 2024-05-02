package com.sistema.examens.servicios.impl;

import com.sistema.examens.dto.gradoDTO;
import com.sistema.examens.dto.mapper.GradoMapper;
import com.sistema.examens.dto.mapper.SeccionMapper;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.dto.seccionDTO;
import com.sistema.examens.entidades.Grado;
import com.sistema.examens.repositorios.GradoRepository;
import com.sistema.examens.servicios.GradoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradoServicioImpl implements GradoServicio {

    @Autowired
    private GradoRepository gradoRepository;

    @Override
    public respuestaDTO guardarGrado(gradoDTO grado) throws Exception{
        Grado gradoNuevo = gradoRepository.findByNombre(grado.getNombre());
        respuestaDTO respuesta = new respuestaDTO();

        if(gradoNuevo !=null){
            System.out.println("Grado ya existe");
            gradoDTO gradoRegistrado = GradoMapper.mapper.convertirGradoToGradoDTO(gradoNuevo);
            respuesta.setMensaje("Grado ya existe");
            respuesta.setCodigo("200");
            respuesta.setData(gradoRegistrado);
        }else{
            Grado registroGrado = new Grado();
            registroGrado = GradoMapper.mapper.convertirGradoDTOtoGrado(grado);
            gradoNuevo = gradoRepository.save(registroGrado);
            respuesta.setMensaje("Grado registrado");
            respuesta.setCodigo("200");
            respuesta.setData(gradoNuevo);
        }
        return respuesta;
    }

    @Override
    public List<gradoDTO> listarGrado() throws Exception{

        List<Grado> lista = gradoRepository.findAll();

        List<gradoDTO> listaGradoDTO = lista.stream().map(
                list -> GradoMapper.mapper.convertirGradoToGradoDTO(list)).collect(Collectors.toList());

        return listaGradoDTO;

    }

    @Override
    public respuestaDTO editarGrado(gradoDTO grado) throws Exception{
        Grado buscarGrado = gradoRepository.buscarxId(grado.getId());
        //Grado modificarGrado = new Grado();
        respuestaDTO respuesta = new respuestaDTO();
        if(buscarGrado!=null){
            buscarGrado.setNombre(grado.getNombre());
            buscarGrado.setAbreviatura(grado.getAbreviatura());
            buscarGrado.setEnabled(grado.getEstado().equals("Activa")?true:false);
            Grado gradoUpdate = gradoRepository.save(buscarGrado);

            gradoDTO gradoDto = GradoMapper.mapper.convertirGradoToGradoDTO(gradoUpdate);
            respuesta.setMensaje("Grado modificado");
            respuesta.setCodigo("200");
            respuesta.setData(gradoDto);
        }else {
            respuesta.setMensaje("grado no encontrada");
            respuesta.setCodigo("404");
            respuesta.setData(null);
        }
        return respuesta;
    }

    @Override
    public respuestaDTO eliminarGrado(Long id) throws Exception {
        respuestaDTO respuesta = new respuestaDTO();
        Grado buscarGrado = gradoRepository.buscarxId(id);
        if(buscarGrado!=null){
            gradoRepository.delete(buscarGrado);
            respuesta.setMensaje("grado eliminado");
            respuesta.setCodigo("200");
            respuesta.setData(null);
        }else {
            respuesta.setMensaje("grado no encontrado");
            respuesta.setCodigo("404");
            respuesta.setData(null);
        }
        return respuesta;
    }
}
