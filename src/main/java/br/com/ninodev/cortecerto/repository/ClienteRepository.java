package br.com.ninodev.cortecerto.repository;

import br.com.ninodev.cortecerto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
