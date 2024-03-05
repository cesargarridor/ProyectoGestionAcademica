package com.cesar.gestionacademica.gestion.repos;

import com.cesar.gestionacademica.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsuario extends JpaRepository<Usuario, Long> {
}
