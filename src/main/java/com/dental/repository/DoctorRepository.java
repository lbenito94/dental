package com.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dental.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
