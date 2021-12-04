package com.dental.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dental.models.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, Long>{

}
