package com.mauro.project.helpdesk;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;


	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "92836596198", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "76488934287", "torvalds@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));

	}
}
