package com.dental.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.models.entity.Especialidad;
import com.dental.models.service.IEspecialidadService;

@Controller
@RequestMapping("/views/especialidades")
public class EspecialidadController {

    @Autowired
    private IEspecialidadService especialidadService;

    @GetMapping("/")
    public String listarEspecialidades(Model model) {
        List<Especialidad> listadoEspecialidades = especialidadService.listarTodos();

        model.addAttribute("titulo", "Lista de Especialidades");
        model.addAttribute("especialidades", listadoEspecialidades);

        return "/views/especialidades/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Especialidad especialidad = new Especialidad();

        model.addAttribute("titulo", "Formulario: Nueva Especialidad");
        model.addAttribute("especialidad", especialidad);

        return "/views/especialidades/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Especialidad especialidad, BindingResult result,
                          Model model, RedirectAttributes attribute) {
        /*   List<Especialidad> listEspecialidades = especialidadService.listaEspecialidades();*/

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nueva Especialidad");
            model.addAttribute("especialidad", especialidad);
            System.out.println("Existieron errores en el formulario");
            return "/views/especialidades/frmCrear";
        }

        especialidadService.guardar(especialidad);
        System.out.println("Especialidad guardado con exito!");
        attribute.addFlashAttribute("success", "Especialidad guardada con exito!");
        return "redirect:/views/especialidades/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idEspecialidad, Model model, RedirectAttributes attribute) {

        Especialidad especialidad = null;

        if (idEspecialidad > 0) {
            especialidad = especialidadService.buscarPorId(idEspecialidad);

            if (especialidad == null) {
                System.out.println("Error: El ID del especialidad no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID de la especialidad no existe!");
                return "redirect:/views/especialidades/";
            }
        }else {
            System.out.println("Error: Error con el ID del Especialidad");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la especialidad");
            return "redirect:/views/especialidades/";
        }

        model.addAttribute("titulo", "Formulario: Editar Especialidad");
        model.addAttribute("especialidad", especialidad);
        return "/views/especialidades/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idEspecialidad, RedirectAttributes attribute) {

        Especialidad especialidad = null;

        if (idEspecialidad > 0) {
            especialidad = especialidadService.buscarPorId(idEspecialidad);

            if (especialidad == null) {
                System.out.println("Error: El ID del especialidad no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID de la especialidad no existe!");
                return "redirect:/views/especialidades/";
            }
        }else {
            System.out.println("Error: Error con el ID del Especialidad");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID de la  Especialidad!");
            return "redirect:/views/especialidades/";
        }

        especialidadService.eliminar(idEspecialidad);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return "redirect:/views/especialidades/";
    }

}
