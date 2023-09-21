package com.mauro.project.helpdesk.services;

import com.mauro.project.helpdesk.dominio.Tecnico;
import com.mauro.project.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository repository;

    public Tecnico findyById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);

    }
}
