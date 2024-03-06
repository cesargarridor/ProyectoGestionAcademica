package com.cesar.gestionacademica.gestion.model;

import jakarta.persistence.*;

@Entity
public class Gestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario;
    private String password;
}
