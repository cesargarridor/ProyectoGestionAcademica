package com.cesar.gestionacademica.gestion.controller;

import com.cesar.gestionacademica.gestion.model.Gestor;
import com.cesar.gestionacademica.gestion.repos.RepoGestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/gestores")
public class ControllerGestor {

    @Autowired
    RepoGestor repoGestor;

    @GetMapping("")
    public String findAll(Model model) {
        List<Gestor> gestores = repoGestor.findAll();
        model.addAttribute("gestores", gestores);
        return "gestores/gestores";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("gestor", new Gestor());
        return "gestores/add";
    }

    @PostMapping("/add")
    public String addGestor(@ModelAttribute("gestor") Gestor gestor) {
        repoGestor.save(gestor);
        return "redirect:/gestores";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") @NonNull Long id, Model model) {
        Optional<Gestor> gestor = repoGestor.findById(id);
        if (gestor.isPresent()) {
            model.addAttribute("gestor", gestor.get());
            return "gestores/delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteGestor(@PathVariable("id") @NonNull Long id) {
        try {
            repoGestor.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/gestores";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id, Model model) {
        Optional<Gestor> gestor = repoGestor.findById(id);
        if (gestor.isPresent()) {
            model.addAttribute("gestor", gestor.get());
            return "gestores/edit";
        } else {
            model.addAttribute("mensaje", "Gestor no encontrado");
            return "error";
        }
    }
}
