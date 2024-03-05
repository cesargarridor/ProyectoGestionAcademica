package com.cesar.gestionacademica.gestion.repos;

import com.cesar.gestionacademica.gestion.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAlumno extends JpaRepository<Alumno, Long> {
}