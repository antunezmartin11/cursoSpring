package com.sistema.examens.servicios.impl;

import com.sistema.examens.dto.areaDTO;
import com.sistema.examens.dto.mapper.AreaMapper;
import com.sistema.examens.dto.respuestaDTO;
import com.sistema.examens.entidades.Area;
import com.sistema.examens.repositorios.AreaRepositorio;
import com.sistema.examens.servicios.AreaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaServicioImpl implements AreaServicio {

    @Autowired
    private AreaRepositorio areaRepositorio;


    @Override
    public respuestaDTO guardar(areaDTO area) throws Exception{

        Area areaNew = areaRepositorio.findByNombre(area.getNombre());
        respuestaDTO respuesta = new respuestaDTO();
        try{

            if(areaNew!=null){

                areaDTO areaRegistrada= AreaMapper.mapper.convertirAreaToAreaDTO(areaNew);
                respuesta.setMensaje("Area ya existe");
                respuesta.setCodigo(String.valueOf(HttpStatus.NO_CONTENT.value()));
                respuesta.setData(areaRegistrada);
            }else{
                Area registroArea = new Area();
                registroArea = AreaMapper.mapper.converitirDTOToArea(area);
                areaNew = areaRepositorio.save(registroArea);
                respuesta.setMensaje("Area registrado");
                respuesta.setCodigo(String.valueOf(HttpStatus.OK.value()));
                respuesta.setData(areaNew);
            }
        }catch (Exception e){
            respuesta.setMensaje(e.getMessage());
        }


        return respuesta;

    }

    @Override
    public respuestaDTO obtenerxNombre(String nombre) throws Exception{
        Area buscar = areaRepositorio.findByNombre(nombre);
        respuestaDTO respuesta = new respuestaDTO();
        if(buscar!=null){
            areaDTO areaRegistrada= AreaMapper.mapper.convertirAreaToAreaDTO(buscar);
            respuesta.setMensaje("Area encontrada");
            respuesta.setCodigo("200");
            respuesta.setData(areaRegistrada);
        }else {
            respuesta.setMensaje("No se encontro el registro");
            respuesta.setCodigo("200");
            respuesta.setData(new ArrayList<String>());
        }
        return respuesta;
    }

    @Override
    public List<areaDTO> listarArea() throws Exception{
        List<Area> lista = areaRepositorio.findAll();

        List<areaDTO> listarAreaDTO = lista.stream().map(
                list -> AreaMapper.mapper.convertirAreaToAreaDTO(list)).collect(Collectors.toList());

        return  listarAreaDTO;
    }

    @Override
    public respuestaDTO actualizarArea(Long id, areaDTO request) throws Exception {
        Optional<Area> area = areaRepositorio.findById(id);
        Area respuestaArea  = area.orElse(null);
        respuestaDTO respuesta = new respuestaDTO();
        if(respuestaArea!=null){
            Area areaRecibida = new Area();
            areaRecibida = AreaMapper.mapper.converitirDTOToArea(request);

            respuestaArea.setNombre(areaRecibida.getNombre());
            respuestaArea.setHoras(areaRecibida.getHoras());
            respuestaArea.setEstado(areaRecibida.isEstado());


            respuestaArea = areaRepositorio.save(respuestaArea);
            respuesta.setCodigo(String.valueOf(HttpStatus.OK));
            respuesta.setData(respuestaArea);
            respuesta.setMensaje("Registro exitoso");
        }else {
            respuesta.setCodigo(String.valueOf(HttpStatus.FOUND));

            respuesta.setMensaje("Ocurrio un error");
        }
        return respuesta;

    }
}
