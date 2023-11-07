package com.sistema.examens.servicios;

import com.sistema.examens.entidades.TipoContrato;

import java.util.List;

public interface TipoContratoServicio {

    public TipoContrato guardar(TipoContrato request) throws Exception;

    public List<TipoContrato> listaTipoContrato() throws Exception;

    public TipoContrato obtenerTipoContrato(String nombre) throws Exception;
}
