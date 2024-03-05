package com.cesar.gestionacademica.gestion.controller;

import com.cesar.gestionacademica.gestion.model.Profesor;
import com.cesar.gestionacademica.gestion.repos.RepoProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profesores")
public class ControllerProfesor {
    @Autowired
    RepoProfesor repoProfesor;

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("profesores", repoProfesor.findAll());
        return "profesores/profesores";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        return "profesores/add";
    }

    @PostMapping("/add")
    public String addProfesor(@ModelAttribute Profesor profesor) {
        repoProfesor.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        Optional<Profesor> profesor = repoProfesor.findById(id);
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
            return "profesores/delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteProfesor(@PathVariable Long id) {
        repoProfesor.deleteById(id);
        return "redirect:/profesores";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Profesor> profesor = repoProfesor.findById(id);
        List<Profesor> profesores = repoProfesor.findAll();
        if (profesor.isPresent()) {
            model.addAttribute("profesor", profesor.get());
            model.addAttribute("profesores", profesores);
            return "profesores/edit";
        } else {
            model.addAttribute("mensaje", "Profesor no encontrado");
            return "error";
        }
    }

}