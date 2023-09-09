package com.sistema.examens.controladores;

import com.sistema.examens.entidades.Cargo_Administrativo;
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
    public Cargo_Administrativo guardarCargo(@RequestBody Cargo_Administrativo cargoAdministrativo) throws Exception{
        return cargoAdministrativoService.guardarCargoAdm(cargoAdministrativo);
    }

    @GetMapping("/listarCargoAdmin")
    public List<Cargo_Administrativo> listarCargoAdmin()throws Exception{
        return cargoAdministrativoService.listarCargoAdm();
    }

    @GetMapping("/obtenerCargo")
    public Cargo_Administrativo obtener(@RequestBody  Cargo_Administrativo cargoAdministrativo)throws Exception{
        return cargoAdministrativoService.obtenerCargo(cargoAdministrativo.getDescripcion());
    }

}
