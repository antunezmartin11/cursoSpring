package com.sistema.examens.servicios;

import com.sistema.examens.entidades.CargoAdministrativo;

import java.util.List;

public interface CargoAdministrativoService {

    public CargoAdministrativo guardarCargoAdm(CargoAdministrativo request) throws Exception;

    public List<CargoAdministrativo> listarCargoAdm() throws Exception;

    public CargoAdministrativo obtenerCargo(String nombre) throws Exception;
}
