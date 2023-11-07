package com.sistema.examens.repositorios;


import com.sistema.examens.entidades.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepositorio extends JpaRepository<Docente, Long> {


}
