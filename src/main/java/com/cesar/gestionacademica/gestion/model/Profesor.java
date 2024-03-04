package com.cesar.gestionacademica.gestion.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String email;

    @ManyToMany(mappedBy = "profesores")
    private Set<Asignatura> asignaturas;
}
