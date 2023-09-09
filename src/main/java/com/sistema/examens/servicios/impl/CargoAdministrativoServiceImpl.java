package com.sistema.examens.servicios.impl;

import com.sistema.examens.dto.usuarioDTO;
import com.sistema.examens.entidades.Cargo_Administrativo;
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

    public Cargo_Administrativo guardarCargoAdm(Cargo_Administrativo request) throws Exception{

        Cargo_Administrativo verificarExiste = cargoAdministrativoRepository.findByDescripcion(request.getDescripcion());
        if(verificarExiste==null){
            Cargo_Administrativo nuevoRegistro = new Cargo_Administrativo();
            nuevoRegistro.setDescripcion(request.getDescripcion());
            nuevoRegistro.setEstado(true);
            nuevoRegistro = cargoAdministrativoRepository.save(nuevoRegistro);
            return nuevoRegistro;
        }else {
            return verificarExiste;
        }
    }

    public List<Cargo_Administrativo> listarCargoAdm() throws Exception{
        List<Cargo_Administrativo> lista = cargoAdministrativoRepository.findAll();
        if(lista.size()>0){
            return lista;
        }else {
            return new ArrayList<>();
        }
    }

    public Cargo_Administrativo obtenerCargo(String nombre) throws Exception{
        Cargo_Administrativo obtenerCargo = cargoAdministrativoRepository.findByDescripcion(nombre);
        if (obtenerCargo!=null){
            return obtenerCargo;
        }else {
            throw new UsuarioFoundException("No existe un registro con ese valor");
        }

    }
}
