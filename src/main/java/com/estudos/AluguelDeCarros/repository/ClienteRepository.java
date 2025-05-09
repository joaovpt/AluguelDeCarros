package com.estudos.AluguelDeCarros.repository;

import com.estudos.AluguelDeCarros.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
