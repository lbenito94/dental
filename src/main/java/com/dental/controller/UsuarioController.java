package com.dental.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dental.models.entity.Rol;
import com.dental.models.entity.Usuario;
import com.dental.models.service.IRolService;
import com.dental.models.service.IUsuarioService;

@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolService rolService;

    @GetMapping("/")
    public String listarUsuarios(Model model) {
        List<Usuario> listadoUsuarios = usuarioService.listarTodos();

        model.addAttribute("titulo", "Lista de Usuarios");
        model.addAttribute("usuarios", listadoUsuarios);

        return "/views/usuarios/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Usuario usuario = new Usuario();
        List<Rol> listRoles = rolService.listaRoles();

        model.addAttribute("titulo", "Formulario: Nuevo Usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", listRoles);

        return "/views/usuarios/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result,
                          Model model, RedirectAttributes attribute) {
        List<Rol> listRoles = rolService.listaRoles();

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Usuario");
            model.addAttribute("usuario", usuario);
            model.addAttribute("roles", listRoles);
            System.out.println("Existieron errores en el formulario");
            return "/views/usuarios/frmCrear";
        }

        usuarioService.guardar(usuario);
        System.out.println("Usuario guardado con exito!");
        attribute.addFlashAttribute("success", "Usuario guardado con exito!");
        return "redirect:/views/usuarios/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idUsuario, Model model, RedirectAttributes attribute) {

        Usuario usuario = null;

        if (idUsuario > 0) {
            usuario = usuarioService.buscarPorId(idUsuario);

            if (usuario == null) {
                System.out.println("Error: El ID del usuario no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del usuario no existe!");
                return "redirect:/views/usuarios/";
            }
        }else {
            System.out.println("Error: Error con el ID del Usuario");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del usuario");
            return "redirect:/views/usuarios/";
        }

        List<Rol> listRoles = rolService.listaRoles();

        model.addAttribute("titulo", "Formulario: Editar Usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", listRoles);

        return "/views/usuarios/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idUsuario, RedirectAttributes attribute) {

        Usuario usuario = null;

        if (idUsuario > 0) {
            usuario = usuarioService.buscarPorId(idUsuario);

            if (usuario == null) {
                System.out.println("Error: El ID del usuario no existe!");
                attribute.addFlashAttribute("error", "ATENCION: El ID del usuario no existe!");
                return "redirect:/views/usuarios/";
            }
        }else {
            System.out.println("Error: Error con el ID del Usuario");
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Usuario!");
            return "redirect:/views/usuarios/";
        }

        usuarioService.eliminar(idUsuario);
        System.out.println("Registro Eliminado con Exito!");
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return "redirect:/views/usuarios/";
    }

}