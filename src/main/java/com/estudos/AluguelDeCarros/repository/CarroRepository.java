package com.estudos.AluguelDeCarros.repository;

import com.estudos.AluguelDeCarros.entity.Carro;
import com.estudos.AluguelDeCarros.enums.StatusCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByStatus(StatusCarro status);
}
