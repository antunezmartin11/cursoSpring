package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.CargoAdministrativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoAdministrativoRepository extends JpaRepository<CargoAdministrativo, Long> {

    public CargoAdministrativo findByDescripcion(String nombre);
}
