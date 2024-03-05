package com.cesar.gestionacademica.gestion.repos;

import com.cesar.gestionacademica.gestion.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAsignatura extends JpaRepository<Asignatura, Long> {
}
