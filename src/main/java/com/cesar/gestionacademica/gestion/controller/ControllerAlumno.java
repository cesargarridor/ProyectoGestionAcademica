package com.cesar.gestionacademica.gestion.controller;

import com.cesar.gestionacademica.gestion.model.Alumno;
import com.cesar.gestionacademica.gestion.model.Profesor;
import com.cesar.gestionacademica.gestion.repos.RepoAlumno;
import io.micrometer.common.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/alumnos")
public class ControllerAlumno {

    @Autowired
    RepoAlumno repoAlumno;

    @GetMapping("")
    public String findAll(Model model) {
        List<Alumno> alumnos = repoAlumno.findAll();
        model.addAttribute("alumnos", alumnos);
        return "alumnos/alumnos";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumnos/add";
    }

    @PostMapping("/add")
    public String addAlumno(@ModelAttribute("alumno") Alumno alumno) {
        repoAlumno.save(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") @NonNull Long id, Model model) {
        Optional<Alumno> alumno = repoAlumno.findById(id);
        if (alumno.isPresent()) {
            model.addAttribute("alumno", alumno.get());
            return "alumnos/delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteAlumno(@PathVariable("id") @NonNull Long id) {
        try {
            repoAlumno.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/alumnos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id, Model model) {
        Optional<Alumno> alumno = repoAlumno.findById(id);
        if (alumno.isPresent()) {
            model.addAttribute("alumno", alumno.get());
            return "alumnos/edit";
        } else {
            model.addAttribute("mensaje", "Alumno no encontrado");
            return "error";
        }
    }
    @PostMapping("/edit/{id}")
    public String editAlumno(@PathVariable("id") @org.springframework.lang.NonNull Long id, @ModelAttribute("profesor") Alumno alumno) {
        repoAlumno.save(alumno);
        return "redirect:/alumnos";
    }
}
