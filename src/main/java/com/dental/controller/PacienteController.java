package com.dental.controller;

import javax.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.models.entity.Paciente;
import com.dental.models.service.IPacienteService;

@Controller
@RequestMapping("/views/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/")
    public String listarPacientes(Model model) {
        List<Paciente> listadoPacientes = pacienteService.listarTodos();

        model.addAttribute("titulo", "Lista de Pacientes");
        model.addAttribute("pacientes", listadoPacientes);

        return "/views/pacientes/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Paciente paciente = new Paciente();


        model.addAttribute("titulo", "Formulario: Nuevo Paciente");
        model.addAttribute("paciente", paciente);


        return "/views/pacientes/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Paciente paciente, BindingResult result,
                          Model model, RedirectAttributes attribute) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Paciente");
            model.addAttribute("paciente", paciente);

            System.out.println("Existieron errores en el formulario");
            return "/views/pacientes/frmCrear";
        }

        pacienteService.guardar(paciente);
        System.out.println("Doctor guardado con exito!");
        attribute.addFlashAttribute("success", "Doctor guardado con exito!");
        return "redirect:/views/pacientes/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idPaciente, Model model, RedirectAttributes attribute) {

        Paciente paciente = null;

        if (idPaciente > 0) {
            paciente = pacienteService.buscarPorId(idPaciente);

            if (paciente == null) {
                System.out.println("Error: El ID del paciente no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del paciente no existe!");
                return "redirect:/views/pacientes/";
            }
        }else {
            System.out.println("Error: Error con el ID del Doctor");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del paciente");
            return "redirect:/views/pacientes/";
        }

        model.addAttribute("titulo", "Formulario: Editar Paciente");
        model.addAttribute("paciente", paciente);


        return "/views/pacientes/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idPaciente, RedirectAttributes attribute) {

        Paciente paciente = null;

        if (idPaciente > 0) {
            paciente = pacienteService.buscarPorId(idPaciente);

            if (paciente == null) {
                System.out.println("Error: El ID del paciente no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del paciente no existe!");
                return "redirect:/views/pacientes/";
            }
        }else {
            System.out.println("Error: Error con el ID del Doctor");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Paciente!");
            return "redirect:/views/pacientes/";
        }

        pacienteService.eliminar(idPaciente);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return "redirect:/views/pacientes/";
    }

}