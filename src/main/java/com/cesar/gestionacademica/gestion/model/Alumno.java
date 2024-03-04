package com.cesar.gestionacademica.gestion.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;

    @ManyToMany(mappedBy = "alumnos")
    private Set<Asignatura> asignaturas;
}
