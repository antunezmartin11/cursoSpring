package com.sistema.examens.servicios;


import com.sistema.examens.entidades.Responsable;

import java.util.List;

public interface ResponsableServicio {

    public Responsable guardar(Responsable area) throws Exception;


    public List<Responsable> listarResponsable() throws Exception;

}
