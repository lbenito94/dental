package com.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dental.model.Rol;

@Repository
public interface RolRepository  extends JpaRepository<Rol,Integer>{

}
