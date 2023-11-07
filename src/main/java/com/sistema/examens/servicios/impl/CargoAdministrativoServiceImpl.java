package com.sistema.examens.servicios.impl;

import com.sistema.examens.entidades.CargoAdministrativo;
import com.sistema.examens.excepciones.UsuarioFoundException;
import com.sistema.examens.repositorios.CargoAdministrativoRepository;
import com.sistema.examens.servicios.CargoAdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoAdministrativoServiceImpl implements CargoAdministrativoService {

    @Autowired
    CargoAdministrativoRepository cargoAdministrativoRepository;

    public CargoAdministrativo guardarCargoAdm(CargoAdministrativo request) throws Exception{

        CargoAdministrativo verificarExiste = cargoAdministrativoRepository.findByDescripcion(request.getDescripcion());
        if(verificarExiste==null){
            CargoAdministrativo nuevoRegistro = new CargoAdministrativo();
            nuevoRegistro.setDescripcion(request.getDescripcion());
            nuevoRegistro.setEstado(true);
            nuevoRegistro = cargoAdministrativoRepository.save(nuevoRegistro);
            return nuevoRegistro;
        }else {
            return verificarExiste;
        }
    }

    public List<CargoAdministrativo> listarCargoAdm() throws Exception{
        List<CargoAdministrativo> lista = cargoAdministrativoRepository.findAll();
        if(lista.size()>0){
            return lista;
        }else {
            return new ArrayList<>();
        }
    }

    public CargoAdministrativo obtenerCargo(String nombre) throws Exception{
        CargoAdministrativo obtenerCargo = cargoAdministrativoRepository.findByDescripcion(nombre);
        if (obtenerCargo!=null){
            return obtenerCargo;
        }else {
            throw new UsuarioFoundException("No existe un registro con ese valor");
        }

    }
}
