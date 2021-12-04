package com.dental.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dental.models.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}