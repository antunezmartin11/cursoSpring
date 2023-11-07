package com.sistema.examens.repositorios;

import com.sistema.examens.entidades.Alumno;
import com.sistema.examens.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    public Persona findByPersona(Persona persona);

    @Query(value = "select count(p.dni) from alumno a inner join persona p on a.id_persona_alumno=p.id_persona and p.dni = :dni", nativeQuery = true)
    public Long cantidadAlumono(String dni);

}

