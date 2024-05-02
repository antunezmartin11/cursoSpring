package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GradoRepository extends JpaRepository<Grado, Long> {

    public Grado findByNombre(String nombre);

    @Query("SELECT g FROM Grado g WHERE g.id = ?1")
    public Grado buscarxId(Long id);


}
