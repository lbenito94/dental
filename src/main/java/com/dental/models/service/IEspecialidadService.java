package com.dental.models.service;

import java.util.List;

import com.dental.models.entity.Especialidad;

public interface IEspecialidadService {

    List<Especialidad> listaEspecialidades();
    public List<Especialidad> listarTodos();
    public void guardar(Especialidad cliente);
    public Especialidad buscarPorId(Long id);
    public void eliminar(Long id);
}
