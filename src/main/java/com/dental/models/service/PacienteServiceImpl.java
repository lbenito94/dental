package com.dental.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.models.entity.Paciente;
import com.dental.models.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarTodos() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    public void guardar(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id)  {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        pacienteRepository.deleteById(id);
    }
}
