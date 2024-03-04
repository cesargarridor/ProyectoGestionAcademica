package com.cesar.gestionacademica.gestion.model;


import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String curso;
    private String ciclo;

    @ManyToMany
    @JoinTable(name = "asignatura_profesor",
            joinColumns = @JoinColumn(name = "asignatura_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private Set<Profesor> profesores;

    @ManyToMany
    @JoinTable(name = "asignatura_alumno",
            joinColumns = @JoinColumn(name = "asignatura_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id"))
    private Set<Alumno> alumnos;

}
