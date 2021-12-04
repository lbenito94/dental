package com.dental.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.models.entity.Doctor;
import com.dental.models.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> listarTodos() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    public void guardar(Doctor especialidad) {
        doctorRepository.save(especialidad);
    }

    @Override
    public Doctor buscarPorId(Long id)  {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        doctorRepository.deleteById(id);
    }
}
