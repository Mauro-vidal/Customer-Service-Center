package com.mauro.project.helpdesk.repositories;

import com.mauro.project.helpdesk.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
