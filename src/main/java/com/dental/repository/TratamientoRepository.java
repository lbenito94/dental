package com.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dental.model.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento,Integer>{

}
