package com.dental.models.service;

import java.util.List;

import com.dental.models.entity.Rol;

public interface IRolService {

    List<Rol> listaRoles();
    public List<Rol> listarTodos();
    public void guardar(Rol rol);
    public Rol buscarPorId(Long id);
    public void eliminar(Long id);
}
