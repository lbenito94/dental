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

import com.dental.model.Especialidad;
import com.dental.repository.EspecialidadRepository;

@Controller
@RequestMapping("/especialidades")   // https://localhost:8080/especialidades
public class EspecialidadController {

    private final Logger logg = LoggerFactory.getLogger(Especialidad.class);
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @GetMapping("")
    public String homeEspecialidad(Model model) {
        model.addAttribute("especialidades",especialidadRepository.findAll());
        return "/especialidad/listarEspecialidad";
    }

    @GetMapping("/create")
    public String createEspecialidad() {
        return "/especialidad/crearEspecialidad";
    }

    @PostMapping("/save")
    public String save(Especialidad especialidad){
        logg.info("LOGG SAVE -> Objeto Nueva Especialidad, {}", especialidad);
        especialidadRepository.save(especialidad);
        return "redirect:/especialidades";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Especialidad p = especialidadRepository.getById(id);
        logg.info("LOGG EDIT ID -> Objeto recuperado {}", p);
        model.addAttribute("especialidades",p);
        return "/especialidad/editarEspecialidad";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Especialidad p = especialidadRepository.getById(id);
        logg.info("LOGG DELETE ID -> Objeto Eliminado {}", p);
        especialidadRepository.delete(p);
        return "redirect:/especialidades";
    }

}
