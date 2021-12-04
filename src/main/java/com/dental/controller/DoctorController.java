package com.dental.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.models.entity.Especialidad;
import com.dental.models.entity.Doctor;
import com.dental.models.service.IEspecialidadService;
import com.dental.models.service.IDoctorService;

@Controller
@RequestMapping("/views/doctores")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @Autowired
    private IEspecialidadService especialidadService;

    @GetMapping("/")
    public String listarDoctores(Model model) {
        List<Doctor> listadoDoctores = doctorService.listarTodos();

        model.addAttribute("titulo", "Lista de Doctores");
        model.addAttribute("doctores", listadoDoctores);

        return "/views/doctores/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Doctor doctor = new Doctor();
        List<Especialidad> listEspecialidades = especialidadService.listaEspecialidades(); // aca 1

        model.addAttribute("titulo", "Formulario: Nuevo Doctor");
        model.addAttribute("doctor", doctor);
        model.addAttribute("especialidades", listEspecialidades);

        return "/views/doctores/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Doctor doctor, BindingResult result,
                          Model model, RedirectAttributes attribute) {
        List<Especialidad> listEspecialidades = especialidadService.listaEspecialidades(); // aca 2

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Doctor");
            model.addAttribute("doctor", doctor);
            model.addAttribute("especialidades", listEspecialidades);
            System.out.println("Existieron errores en el formulario");
            return "/views/doctores/frmCrear";
        }

        doctorService.guardar(doctor);
        System.out.println("Doctor guardado con exito!");
        attribute.addFlashAttribute("success", "Doctor guardado con exito!");
        return "redirect:/views/doctores/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idDoctor, Model model, RedirectAttributes attribute) {

        Doctor doctor = null;

        if (idDoctor > 0) {
            doctor = doctorService.buscarPorId(idDoctor);

            if (doctor == null) {
                System.out.println("Error: El ID del doctor no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del doctor no existe!");
                return "redirect:/views/doctores/";
            }
        }else {
            System.out.println("Error: Error con el ID del Doctor");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del doctor");
            return "redirect:/views/doctores/";
        }

        List<Especialidad> listEspecialidades = especialidadService.listaEspecialidades(); //aca 3

        model.addAttribute("titulo", "Formulario: Editar Doctor");
        model.addAttribute("doctor", doctor);
        model.addAttribute("especialidades", listEspecialidades);

        return "/views/doctores/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idDoctor, RedirectAttributes attribute) {

        Doctor doctor = null;

        if (idDoctor > 0) {
            doctor = doctorService.buscarPorId(idDoctor);

            if (doctor == null) {
                System.out.println("Error: El ID del doctor no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del doctor no existe!");
                return "redirect:/views/doctores/";
            }
        }else {
            System.out.println("Error: Error con el ID del Doctor");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Doctor!");
            return "redirect:/views/doctores/";
        }

        doctorService.eliminar(idDoctor);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return "redirect:/views/doctores/";
    }

}