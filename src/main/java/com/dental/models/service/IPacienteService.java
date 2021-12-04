package com.dental.models.service;

import com.dental.models.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    public List<Paciente> listarTodos();
    public void guardar(Paciente paciente);
    public Paciente buscarPorId(Long id);
    public void eliminar(Long id);
}
