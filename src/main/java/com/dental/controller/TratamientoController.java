package com.dental.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.models.entity.Tratamiento;
import com.dental.models.service.ITratamientoService;

@Controller
@RequestMapping("/views/tratamientos")
public class TratamientoController {

    @Autowired
    private ITratamientoService tratamientoService;

    @GetMapping("/")
    public String listarTratamientos(Model model) {
        List<Tratamiento> listadoTratamientos = tratamientoService.listarTodos();

        model.addAttribute("titulo", "Lista de Tratamientos");
        model.addAttribute("tratamientos", listadoTratamientos);

        return "/views/tratamientos/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Tratamiento tratamiento = new Tratamiento();

        model.addAttribute("titulo", "Formulario: Nuevo Tratamiento");
        model.addAttribute("tratamiento", tratamiento);

        return "/views/tratamientos/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Tratamiento tratamiento, BindingResult result,
                          Model model, RedirectAttributes attribute) {
        /*   List<Tratamiento> listTratamientos = tratamientoService.listaTratamientos();*/

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Tratamiento");
            model.addAttribute("tratamiento", tratamiento);
            System.out.println("Existieron errores en el formulario");
            return "/views/tratamientos/frmCrear";
        }

        tratamientoService.guardar(tratamiento);
        System.out.println("Tratamiento guardado con exito!");
        attribute.addFlashAttribute("success", "Tratamiento guardada con exito!");
        return "redirect:/views/tratamientos/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idTratamiento, Model model, RedirectAttributes attribute) {

        Tratamiento tratamiento = null;

        if (idTratamiento > 0) {
            tratamiento = tratamientoService.buscarPorId(idTratamiento);

            if (tratamiento == null) {
                System.out.println("Error: El ID del tratamiento no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID de la tratamiento no existe!");
                return "redirect:/views/tratamientos/";
            }
        }else {
            System.out.println("Error: Error con el ID del Tratamiento");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del tratamiento");
            return "redirect:/views/tratamientos/";
        }

        model.addAttribute("titulo", "Formulario: Editar Tratamiento");
        model.addAttribute("tratamiento", tratamiento);
        return "/views/tratamientos/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idTratamiento, RedirectAttributes attribute) {

        Tratamiento tratamiento = null;

        if (idTratamiento > 0) {
            tratamiento = tratamientoService.buscarPorId(idTratamiento);

            if (tratamiento == null) {
                System.out.println("Error: El ID del tratamiento no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del tratamiento no existe!");
                return "redirect:/views/tratamientos/";
            }
        }else {
            System.out.println("Error: Error con el ID del Tratamiento");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del tratamiento!");
            return "redirect:/views/tratamientos/";
        }

        tratamientoService.eliminar(idTratamiento);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return "redirect:/views/tratamientos/";
    }

}
