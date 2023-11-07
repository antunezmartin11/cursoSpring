package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Area;

import java.util.List;

public interface AreaServicio {

    public Area guardar(Area area) throws Exception;

    public Area obtenerxNombre(String nombre) throws Exception;

    public List<Area> listarArea() throws Exception;
}
