package com.mauro.project.helpdesk.services;

import com.mauro.project.helpdesk.domain.enums.Prioridade;
import com.mauro.project.helpdesk.domain.enums.Status;
import com.mauro.project.helpdesk.dominio.Chamado;
import com.mauro.project.helpdesk.dominio.Cliente;
import com.mauro.project.helpdesk.dominio.Tecnico;
import com.mauro.project.helpdesk.dtos.ChamadoDTO;
import com.mauro.project.helpdesk.repositories.ChamadoRepository;
import com.mauro.project.helpdesk.services.exceptions.ObjectnotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<Chamado> findAll(){
        return repository.findAll();
    }

    public Chamado create(@Valid ChamadoDTO objDto) {
        return repository.save(newChamado(objDto));
    }

    private Chamado newChamado(ChamadoDTO obj){
        Tecnico tecnico = tecnicoService.findyById(obj.getTecnico());
        Cliente cliente = clienteService.findyById(obj.getCliente());

        Chamado chamado = new Chamado();
        if (obj.getId() != null){
            chamado.setId(obj.getId());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }
}
