package com.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dental.model.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Integer>{

}
