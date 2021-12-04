package com.dental.models.service;

import java.util.List;

import com.dental.models.entity.Doctor;

public interface IDoctorService {

    public List<Doctor> listarTodos();
    public void guardar(Doctor doctor);
    public Doctor buscarPorId(Long id);
    public void eliminar(Long id);
}
