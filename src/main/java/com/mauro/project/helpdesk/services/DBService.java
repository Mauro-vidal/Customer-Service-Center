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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB(){


        Tecnico tec1 = new Tecnico(null, "Valdir cezar", "92836596198", "valdir@mail.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Mauro João Mendes Vidal", "106.793.799-40", "mauroviidal@gmail.com", encoder.encode("123456"));
        tec2.addPerfil(Perfil.TECNICO);;
        Tecnico tec3 = new Tecnico(null, "João Pedro", "271.068.470-54", "joaop@mail.com", encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null, "Dorival Junior", "162.720.120-39", "dorivaljunior@mail.com", encoder.encode("300"));
        Tecnico tec5 = new Tecnico(null, "Jorge Jesus", "778.556.170-27", "jorgejj@mail.com", encoder.encode("8070a2"));


        Cliente cli1 = new Cliente(null, "Linus Torvalds", "764.889.34-87", "torvalds@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Alberto Junior", "644.900.323-58", "albertojunior@mail.com", encoder.encode("456"));
        Cliente cli3 = new Cliente(null, "Mauricio Roberto", "792.043.830-62", "mauricinho@mail.com", encoder.encode("999"));
        Cliente cli4 = new Cliente(null, "Adolfo Vidal", "300.220.800-78", "adolfv@mail.com", encoder.encode("745"));
        Cliente cli5 = new Cliente(null, "Roberto Augusto", "081.399.300-83", "raugusto@mail.com", encoder.encode("4aw322"));
        Cliente cli6 = new Cliente(null, "Delete", "63355747998", "testedelete@gmail.com", encoder.encode("deletar"));


        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Chamado com urgência", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Chamado de Mauricio, técnico João Pedro", tec3, cli3 );
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 6", "Teste chamado 6", tec1, cli5 );
        Chamado c7 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 7", "Teste de chamado 7", tec5, cli4);


        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
    }

}
