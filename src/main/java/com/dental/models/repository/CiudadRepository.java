package com.dental.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.dental.models.entity.Ciudad;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

}
