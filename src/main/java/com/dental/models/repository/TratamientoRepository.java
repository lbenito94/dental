package com.dental.models.repository;

import com.dental.models.entity.Tratamiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends CrudRepository<Tratamiento, Long> {

}
