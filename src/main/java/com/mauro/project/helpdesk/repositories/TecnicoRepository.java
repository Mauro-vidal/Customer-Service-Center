package com.mauro.project.helpdesk.repositories;

import com.mauro.project.helpdesk.dominio.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
