package com.dental.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.models.entity.Rol;
import com.dental.models.repository.RolRepository;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listaRoles() {

        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public List<Rol> listarTodos() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public void guardar(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public Rol buscarPorId(Long id)  {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        rolRepository.deleteById(id);
    }
}
