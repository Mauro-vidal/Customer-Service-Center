package com.mauro.project.helpdesk.repositories;

import com.mauro.project.helpdesk.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
