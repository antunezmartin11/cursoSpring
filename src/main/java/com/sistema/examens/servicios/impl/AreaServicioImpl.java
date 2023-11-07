package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.Area;
import com.sistema.examens.repositorios.AreaRepositorio;
import com.sistema.examens.servicios.AreaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServicioImpl implements AreaServicio {

    @Autowired
    private AreaRepositorio areaRepositorio;


    @Override
    public Area guardar(Area area) throws Exception{
        Area areaNew = areaRepositorio.findByNombre(area.getNombre());
        if(areaNew!=null){
            System.out.println("Seccion ya existe");
        }else{
            areaNew = areaRepositorio.save(area);
        }

        return areaNew;

    }

    @Override
    public Area obtenerxNombre(String nombre) throws Exception{
        Area buscar = areaRepositorio.findByNombre(nombre);
        if(buscar!=null){
            return buscar;
        }else {
            return new Area();
        }
    }

    @Override
    public List<Area> listarArea() throws Exception{
        List<Area> lista = areaRepositorio.findAll();

        if(lista.size()>0){
            return  lista;
        }else
            return new ArrayList<Area>();
    }
}
