package com.dental.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.models.entity.Rol;
import com.dental.models.service.IRolService;

@Controller
@RequestMapping("/views/roles")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/")
    public String listarRoles(Model model) {
        List<Rol> listadoRoles = rolService.listaRoles();

        model.addAttribute("titulo", "Lista de Roles");
        model.addAttribute("roles", listadoRoles);

        return "/views/roles/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Rol rol = new Rol();

        model.addAttribute("titulo", "Formulario: Nuevo Rol");
        model.addAttribute("rol", rol);

        return "/views/roles/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Rol rol, BindingResult result,
                          Model model, RedirectAttributes attribute) {
     /*   List<Rol> listRoles = rolService.listaRoles();*/

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Rol");
            model.addAttribute("rol", rol);
            System.out.println("Existieron errores en el formulario");
            return "/views/roles/frmCrear";
        }

        rolService.guardar(rol);
        System.out.println("Rol guardado con exito!");
        attribute.addFlashAttribute("success", "Rol guardado con exito!");
        return "redirect:/views/roles/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idRol, Model model, RedirectAttributes attribute) {

        Rol rol = null;

        if (idRol > 0) {
            rol = rolService.buscarPorId(idRol);

            if (rol == null) {
                System.out.println("Error: El ID del rol no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del rol no existe!");
                return "redirect:/views/roles/";
            }
        }else {
            System.out.println("Error: Error con el ID del Rol");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del rol");
            return "redirect:/views/roles/";
        }

        model.addAttribute("titulo", "Formulario: Editar Rol");
        model.addAttribute("rol", rol);
        return "/views/roles/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idRol, RedirectAttributes attribute) {

        Rol rol = null;

        if (idRol > 0) {
            rol = rolService.buscarPorId(idRol);

            if (rol == null) {
                System.out.println("Error: El ID del rol no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del rol no existe!");
                return "redirect:/views/roles/";
            }
        }else {
            System.out.println("Error: Error con el ID del Rol");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Rol!");
            return "redirect:/views/roles/";
        }

        rolService.eliminar(idRol);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return "redirect:/views/roles/";
    }

}