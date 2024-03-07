package com.cesar.gestionacademica.gestion.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.cesar.gestionacademica.gestion.model.Asignatura;
import com.cesar.gestionacademica.gestion.model.Profesor;
import com.cesar.gestionacademica.gestion.repos.RepoAsignatura;
import com.cesar.gestionacademica.gestion.repos.RepoProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profesores")
public class ControllerProfesor {

    @Autowired
    private RepoProfesor repoProfesor;

    @Autowired
    private RepoAsignatura repoAsignatura;

    @GetMapping("")
    public String findAll(Model model) {
        List<Profesor> profesores = repoProfesor.findAll();
        for (Profesor profesor : profesores) {
            profesor.setAsignaturas(new HashSet<>()); // Asigna un conjunto vacío de asignaturas
        }
        model.addAttribute("profesores", profesores);
        return "profesores/profesores";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "profesores/add";
    }

    @PostMapping("/add")
    public String addProfesor(@ModelAttribute("profesor") Profesor profesor) {
        repoProfesor.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") @NonNull Long id, Model model) {
        Optional<Profesor> profesor = repoProfesor.findById(id);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
            return "profesores/delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteProfesor(@PathVariable("id") @NonNull Long id) {
        try {
            repoProfesor.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/profesores";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id, Model model) {
        Optional<Profesor> profesor = repoProfesor.findById(id);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
            return "profesores/edit";
        } else {
            model.addAttribute("mensaje", "Profesor no encontrado");
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String editProfesor(@PathVariable("id") @NonNull Long id, @ModelAttribute("profesor") Profesor profesor) {
        repoProfesor.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/asignar/{id}")
    public String asignarAsignaturasForm(@PathVariable("id") @NonNull Long id, Model model) {
        Optional<Profesor> profesor = repoProfesor.findById(id);
        if (profesor.isPresent()) {
            List<Asignatura> asignaturas = repoAsignatura.findAll();
            model.addAttribute("profesor", profesor.get());
            model.addAttribute("asignaturas", asignaturas);
            return "profesores/asignar";
        } else {
            model.addAttribute("mensaje", "Profesor no encontrado");
            return "error";
        }
    }


    @PostMapping("/asignar/{id}")
    public String asignarAsignaturas(@PathVariable("id") @NonNull Long id, @RequestParam("asignatura") Long asignaturaId, Model model) {
        Optional<Profesor> profesorOptional = repoProfesor.findById(id);
        Optional<Asignatura> asignaturaOptional = repoAsignatura.findById(asignaturaId);
        if (profesorOptional.isPresent() && asignaturaOptional.isPresent()) {
            Profesor profesor = profesorOptional.get();
            Asignatura asignatura = asignaturaOptional.get();
            profesor.getAsignaturas().add(asignatura);
            repoProfesor.save(profesor);
            model.addAttribute("asignaturaSeleccionada", asignatura);

            return "redirect:/profesores";
        } else {
            return "error";
        }
    }










}
