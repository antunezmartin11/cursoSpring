package com.sistema.examens.servicios;

import com.sistema.examens.entidades.TipoUsuario;

import java.util.List;

public interface TipoUsuarioServicio {

    public TipoUsuario guardarTipoUsuario(TipoUsuario tipoUsuario) throws  Exception;

    public List<TipoUsuario> listarTipoUsuario () throws Exception;
}
