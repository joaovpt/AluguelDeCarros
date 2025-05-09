package com.estudos.AluguelDeCarros.repository;

import com.estudos.AluguelDeCarros.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
