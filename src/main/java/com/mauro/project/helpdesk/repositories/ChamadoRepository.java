package com.mauro.project.helpdesk.repositories;

import com.mauro.project.helpdesk.dominio.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer > {
}
