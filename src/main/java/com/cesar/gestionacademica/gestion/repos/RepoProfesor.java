package com.cesar.gestionacademica.gestion.repos;

import com.cesar.gestionacademica.gestion.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProfesor extends JpaRepository<Profesor, Long> {
}
