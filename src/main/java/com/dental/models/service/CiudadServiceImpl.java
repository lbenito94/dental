package com.dental.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.models.entity.Ciudad;
import com.dental.models.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> listaCiudades() {

        return (List<Ciudad>) ciudadRepository.findAll();
    }

}