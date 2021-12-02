package com.dental.controller;

import com.dental.model.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dental.repository.PacienteRepository;

@Controller
@RequestMapping("/pacientes")   // https://localhost:8080/pacientes
public class PacienteController {

    private final Logger logg = LoggerFactory.getLogger(Paciente.class);
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("pacientes",pacienteRepository.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String createPaciente() {
        return "crearPaciente";
    }

    @PostMapping("/save")
    public String save(Paciente paciente){
        logg.info("Informacion del objeto Paciente, {}", paciente);
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }
}
