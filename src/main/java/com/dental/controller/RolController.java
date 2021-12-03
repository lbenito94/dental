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

import com.dental.model.Rol;
import com.dental.repository.RolRepository;

@Controller
@RequestMapping("/roles")   // https://localhost:8080/roles
public class RolController {

    private final Logger logg = LoggerFactory.getLogger(Rol.class);
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("")
    public String homeRol(Model model) {
        model.addAttribute("roles",rolRepository.findAll());
        return "/rol/listarRol";
    }

    @GetMapping("/create")
    public String createEspecialidad() {
        return "/rol/crearRol";
    }

    @PostMapping("/save")
    public String save(Rol rol){
        logg.info("LOGG SAVE -> Objeto Nuevo Rol, {}", rol);
        rolRepository.save(rol);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Rol p = rolRepository.getById(id);
        logg.info("LOGG EDIT ID -> Objeto recuperado {}", p);
        model.addAttribute("roles",p);
        return "/rol/editarRol";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Rol p = rolRepository.getById(id);
        logg.info("LOGG DELETE ID -> Objeto Eliminado {}", p);
        rolRepository.delete(p);
        return "redirect:/roles";
    }

}
