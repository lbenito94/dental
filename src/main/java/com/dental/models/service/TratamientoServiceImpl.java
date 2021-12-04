package com.dental.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.models.entity.Tratamiento;
import com.dental.models.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements ITratamientoService {

    @Override
    public List<Tratamiento> listaTratamientos() {
        return (List<Tratamiento>) tratamientoRepository.findAll();
    }

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> listarTodos() {
        return (List<Tratamiento>) tratamientoRepository.findAll();
    }

    @Override
    public void guardar(Tratamiento especialidad) {
        tratamientoRepository.save(especialidad);
    }

    @Override
    public Tratamiento buscarPorId(Long id)  {
        return tratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        tratamientoRepository.deleteById(id);
    }

}
