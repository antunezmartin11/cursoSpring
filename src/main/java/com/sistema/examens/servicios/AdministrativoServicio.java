package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Administrativo;

public interface AdministrativoServicio {

    public Administrativo guardar(Administrativo request) throws Exception;

    public Administrativo obtener(Administrativo request) throws Exception;


}
