package com.cesar.gestionacademica.gestion.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cesar.gestionacademica.gestion.model.Usuario;
import com.cesar.gestionacademica.gestion.repos.RepoUsuario;

@Controller
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("")
    public String findAll(Model model) {
        List<Usuario> usuarios = repoUsuario.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/usuarios";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/add";
    }

    @PostMapping("/add")
    public String addUsuario(@ModelAttribute("usuario") Usuario usuario) {
        repoUsuario.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") @NonNull Long id, Model model) {
        Optional<Usuario> usuario = repoUsuario.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") @NonNull Long id) {
        try {
            repoUsuario.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id, Model model) {
        Optional<Usuario> usuario = repoUsuario.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/edit";
        } else {
            model.addAttribute("mensaje", "Usuario no encontrado");
            return "error";
        }
    }
}
