package com.cesar.gestionacademica.gestion.repos;

import com.cesar.gestionacademica.gestion.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoGestor extends JpaRepository<Gestor, Long> {
}