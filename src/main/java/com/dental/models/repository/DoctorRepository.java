package com.dental.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dental.models.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{

}
