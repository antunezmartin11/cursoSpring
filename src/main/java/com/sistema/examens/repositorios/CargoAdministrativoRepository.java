package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Cargo_Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoAdministrativoRepository extends JpaRepository<Cargo_Administrativo, Long> {

    public Cargo_Administrativo findByDescripcion(String nombre);
}
