package com.dental.models.service;

import java.util.List;

import com.dental.models.entity.Usuario;

public interface IUsuarioService {

    public List<Usuario> listarTodos();
    public void guardar(Usuario usuario);
    public Usuario buscarPorId(Long id);
    public void eliminar(Long id);

}
