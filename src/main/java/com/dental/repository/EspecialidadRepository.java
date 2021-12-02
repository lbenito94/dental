package com.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dental.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer>{

}
