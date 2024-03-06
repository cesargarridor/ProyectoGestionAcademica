package com.cesar.gestionacademica.gestion.model;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String email;

    @ManyToMany(mappedBy = "profesores")
    private Set<Asignatura> asignaturas;
}
