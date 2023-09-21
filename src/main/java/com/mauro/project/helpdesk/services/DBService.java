package com.mauro.project.helpdesk.services;

import com.mauro.project.helpdesk.domain.enums.Perfil;
import com.mauro.project.helpdesk.domain.enums.Prioridade;
import com.mauro.project.helpdesk.domain.enums.Status;
import com.mauro.project.helpdesk.dominio.Chamado;
import com.mauro.project.helpdesk.dominio.Cliente;
import com.mauro.project.helpdesk.dominio.Tecnico;
import com.mauro.project.helpdesk.repositories.ChamadoRepository;
import com.mauro.project.helpdesk.repositories.ClienteRepository;
import com.mauro.project.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB(){


        Tecnico tec1 = new Tecnico(null, "Valdir cezar", "92836596198", "valdir@mail.com", "123");
        Tecnico tec2 = new Tecnico(null, "Mauro João Mendes Vidal", "10679379940", "mauroviidal@gmail.com", "123456");
        tec1.addPerfil(Perfil.ADMIN);
        tec2.addPerfil(Perfil.TECNICO);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "76488934287", "torvalds@mail.com", "123");
        Cliente cli2 = new Cliente(null, "Alberto Junior", "64490032358", "albertojunior@mail.com", "456");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 02", "Chamado com urgência", tec2, cli2);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        chamadoRepository.saveAll(Arrays.asList(c1, c2));
    }

}
