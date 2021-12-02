package com.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dental.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
