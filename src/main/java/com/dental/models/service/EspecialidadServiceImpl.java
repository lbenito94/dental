package com.dental.models.service;

import java.util.List;

import com.dental.models.entity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.models.entity.Especialidad;
import com.dental.models.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    @Override
    public List<Especialidad> listaEspecialidades() {

        return (List<Especialidad>) especialidadRepository.findAll();
    }

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> listarTodos() {
        return (List<Especialidad>) especialidadRepository.findAll();
    }

    @Override
    public void guardar(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad buscarPorId(Long id)  {
        return especialidadRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        especialidadRepository.deleteById(id);
    }

}
