package com.dental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dental.model.Usuario;
import com.dental.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")   // https://localhost:8080/usuarios
public class UsuarioController {

    private final Logger logg = LoggerFactory.getLogger(Usuario.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String homeUsuario(Model model) {
        model.addAttribute("usuarios",usuarioRepository.findAll());
        return "/usuario/listarUsuario";
    }

    @GetMapping("/create")
    public String createEspecialidad() {
        return "/usuario/crearUsuario";
    }

    @PostMapping("/save")
    public String save(Usuario usuario){
        logg.info("LOGG SAVE -> Objeto Nuevo Usuario, {}", usuario);
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Usuario p = usuarioRepository.getById(id);
        logg.info("LOGG EDIT ID -> Objeto recuperado {}", p);
        model.addAttribute("usuarios",p);
        return "/usuario/editarUsuario";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Usuario p = usuarioRepository.getById(id);
        logg.info("LOGG DELETE ID -> Objeto Eliminado {}", p);
        usuarioRepository.delete(p);
        return "redirect:/usuarios";
    }
}
