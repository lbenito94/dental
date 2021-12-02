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

import com.dental.model.Paciente;
import com.dental.repository.PacienteRepository;

@Controller
@RequestMapping("/pacientes")   // https://localhost:8080/pacientes
public class PacienteController {

    private final Logger logg = LoggerFactory.getLogger(Paciente.class);
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("")
    public String homePaciente(Model model) {
        model.addAttribute("pacientes",pacienteRepository.findAll());
        return "/paciente/listarPaciente";
    }

    @GetMapping("/create")
    public String createPaciente() {
        return "/paciente/crearPaciente";
    }

    @PostMapping("/save")
    public String save(Paciente paciente){
        logg.info("LOGG SAVE -> Objeto Nuevo Paciente, {}", paciente);
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Paciente p = pacienteRepository.getById(id);
        logg.info("LOGG EDIT ID -> Objeto recuperado {}", p);
        model.addAttribute("pacientes",p);
        return "/paciente/editarPaciente";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Paciente p = pacienteRepository.getById(id);
        logg.info("LOGG DELETE ID -> Objeto Eliminado {}", p);
        pacienteRepository.delete(p);
        return "redirect:/pacientes";
    }
}
