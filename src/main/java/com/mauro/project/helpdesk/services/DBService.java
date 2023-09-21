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
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Mauro João Mendes Vidal", "106.793.799-40", "mauroviidal@gmail.com", "123456");
        tec2.addPerfil(Perfil.TECNICO);;
        Tecnico tec3 = new Tecnico(null, "João Pedro", "271.068.470-54", "joaop@mail.com", "123");
        Tecnico tec4 = new Tecnico(null, "Dorival Junior", "162.720.120-39", "dorivaljunior@mail.com", "300");
        Tecnico tec5 = new Tecnico(null, "Jorge Jesus", "778.556.170-27", "jorgejj@mail.com", "8070a2");


        Cliente cli1 = new Cliente(null, "Linus Torvalds", "764.889.34-87", "torvalds@mail.com", "123");
        Cliente cli2 = new Cliente(null, "Alberto Junior", "644.900.323-58", "albertojunior@mail.com", "456");
        Cliente cli3 = new Cliente(null, "Mauricio Roberto", "792.043.830-62", "mauricinho@mail.com", "999");
        Cliente cli4 = new Cliente(null, "Adolfo Vidal", "300.220.800-78", "adolfv@mail.com", "745");
        Cliente cli5 = new Cliente(null, "Roberto Augusto", "081.399.300-83", "raugusto@mail.com", "4aw322");


        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Chamado com urgência", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Chamado de Mauricio, técnico João Pedro", tec3, cli3 );
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 6", "Teste chamado 6", tec1, cli5 );
        Chamado c7 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 7", "Teste de chamado 7", tec5, cli4);


        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
    }

}
//    @Autowired
//    private ChamadoRepository chamadoRepository;
//    @Autowired
//    private PessoaRepository pessoaRepository;
//
//    public void instanciaDB() {
//
//        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "550.482.150-95", "valdir@mail.com", "123");
//        tec1.addPerfil(Perfil.ADMIN);
//        Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
//        Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
//        Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
//        Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");
//
//        Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", "123");
//        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
//        Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
//        Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
//        Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");
//
//
//        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
//        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
//        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
//        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
//        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
//        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);
//
//        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
//        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
//    }
//}