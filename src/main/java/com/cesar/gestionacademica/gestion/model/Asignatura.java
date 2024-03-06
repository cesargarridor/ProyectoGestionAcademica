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

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
