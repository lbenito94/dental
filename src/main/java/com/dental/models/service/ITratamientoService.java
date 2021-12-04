package com.dental.models.service;

import com.dental.models.entity.Tratamiento;

import java.util.List;

public interface ITratamientoService {

    List<Tratamiento> listaTratamientos();
    public List<Tratamiento> listarTodos();
    public void guardar(Tratamiento tratamiento);
    public Tratamiento buscarPorId(Long id);
    public void eliminar(Long id);
}
