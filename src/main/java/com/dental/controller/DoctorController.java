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

import com.dental.model.Doctor;
import com.dental.repository.DoctorRepository;

@Controller
@RequestMapping("/doctores")   // https://localhost:8080/doctores
public class DoctorController {

    private final Logger logg = LoggerFactory.getLogger(Doctor.class);
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("")
    public String homeDoctor(Model model) {
        model.addAttribute("doctores",doctorRepository.findAll());
        return "/doctor/listarDoctor";
    }

    @GetMapping("/create")
    public String createDoctor() {
        return "/doctor/crearDoctor";
    }

    @PostMapping("/save")
    public String save(Doctor doctor){
        logg.info("LOGG SAVE -> Objeto Nuevo Doctor, {}", doctor);
        doctorRepository.save(doctor);
        return "redirect:/doctores";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Doctor p = doctorRepository.getById(id);
        logg.info("LOGG EDIT ID -> Objeto recuperado {}", p);
        model.addAttribute("doctores",p);
        return "/doctor/editarDoctor";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Doctor p = doctorRepository.getById(id);
        logg.info("LOGG DELETE ID -> Objeto Eliminado {}", p);
        doctorRepository.delete(p);
        return "redirect:/doctores";
    }
}
