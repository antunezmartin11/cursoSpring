package com.sistema.examens.servicios;

import com.sistema.examens.entidades.Cargo_Administrativo;

import java.util.List;

public interface CargoAdministrativoService {

    public Cargo_Administrativo guardarCargoAdm(Cargo_Administrativo request) throws Exception;

    public List<Cargo_Administrativo> listarCargoAdm() throws Exception;

    public Cargo_Administrativo obtenerCargo(String nombre) throws Exception;
}
