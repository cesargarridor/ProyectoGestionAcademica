package com.cesar.gestionacademica.gestion.controller;

import java.util.List;
import java.util.Optional;

import com.cesar.gestionacademica.gestion.model.Asignatura;
import com.cesar.gestionacademica.gestion.repos.RepoAsignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/asignaturas")
public class ControllerAsignatura {

    @Autowired
    RepoAsignatura repoAsignatura;

    @GetMapping("")
    public String findAll(Model model) {
        List<Asignatura> asignaturas = repoAsignatura.findAll();
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturas/asignaturas";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "asignaturas/add";
    }

    @PostMapping("/add")
    public String addAsignatura(@ModelAttribute("asignatura") Asignatura asignatura) {
        repoAsignatura.save(asignatura);
        return "redirect:/asignaturas";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") @NonNull Long id, Model model) {
        Optional<Asignatura> asignatura = repoAsignatura.findById(id);
        if (asignatura.isPresent()) {
            model.addAttribute("asignatura", asignatura.get());
            return "asignaturas/delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteAsignatura(@PathVariable("id") @NonNull Long id) {
        try {
            repoAsignatura.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/asignaturas";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id, Model model) {
        Optional<Asignatura> asignatura = repoAsignatura.findById(id);
        if (asignatura.isPresent()) {
            model.addAttribute("asignatura", asignatura.get());
            return "asignaturas/edit";
        } else {
            model.addAttribute("mensaje", "Asignatura no encontrada");
            return "error";
        }
    }
}
