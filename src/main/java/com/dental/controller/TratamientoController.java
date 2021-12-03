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

import com.dental.model.Tratamiento;
import com.dental.repository.TratamientoRepository;

@Controller
@RequestMapping("/tratamientos")   // https://localhost:8080/tratamientos
public class TratamientoController {

    private final Logger logg = LoggerFactory.getLogger(Tratamiento.class);
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @GetMapping("")
    public String homeTratamiento(Model model) {
        model.addAttribute("tratamientos",tratamientoRepository.findAll());
        return "/tratamiento/listarTratamiento";
    }

    @GetMapping("/create")
    public String createEspecialidad() {
        return "/tratamiento/crearTratamiento";
    }

    @PostMapping("/save")
    public String save(Tratamiento tratamiento){
        logg.info("LOGG SAVE -> Objeto Nuevo Tratamiento, {}", tratamiento);
        tratamientoRepository.save(tratamiento);
        return "redirect:/tratamientos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Tratamiento p = tratamientoRepository.getById(id);
        logg.info("LOGG EDIT ID -> Objeto recuperado {}", p);
        model.addAttribute("tratamientos",p);
        return "/tratamiento/editarTratamiento";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Tratamiento p = tratamientoRepository.getById(id);
        logg.info("LOGG DELETE ID -> Objeto Eliminado {}", p);
        tratamientoRepository.delete(p);
        return "redirect:/tratamientos";
    }
}
