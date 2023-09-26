package com.mauro.project.helpdesk.services;

import com.mauro.project.helpdesk.dominio.Chamado;
import com.mauro.project.helpdesk.repositories.ChamadoRepository;
import com.mauro.project.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
    }
}
