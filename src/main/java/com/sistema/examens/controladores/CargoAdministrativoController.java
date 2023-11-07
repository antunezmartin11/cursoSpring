package com.sistema.examens.controladores;

import com.sistema.examens.entidades.CargoAdministrativo;
import com.sistema.examens.servicios.CargoAdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargoAdministrativo")
@CrossOrigin("*")
public class CargoAdministrativoController {
@Autowired
    private CargoAdministrativoService cargoAdministrativoService;

    @PostMapping("/")
    public CargoAdministrativo guardarCargo(@RequestBody CargoAdministrativo cargoAdministrativo) throws Exception{
        return cargoAdministrativoService.guardarCargoAdm(cargoAdministrativo);
    }

    @GetMapping("/listarCargoAdmin")
    public List<CargoAdministrativo> listarCargoAdmin()throws Exception{
        return cargoAdministrativoService.listarCargoAdm();
    }

    @GetMapping("/obtenerCargo")
    public CargoAdministrativo obtener(@RequestBody CargoAdministrativo cargoAdministrativo)throws Exception{
        return cargoAdministrativoService.obtenerCargo(cargoAdministrativo.getDescripcion());
    }

}
