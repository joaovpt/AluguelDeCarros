package com.estudos.AluguelDeCarros.service;

import com.estudos.AluguelDeCarros.entity.Carro;
import com.estudos.AluguelDeCarros.enums.StatusCarro;
import com.estudos.AluguelDeCarros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro salvar(Carro carro) {
        carro.setStatus(StatusCarro.DISPONIVEL);
        return carroRepository.save(carro);
    }

    public List<Carro> listarTodos(){
        return carroRepository.findAll();
    }

    public List<Carro> listarDisponiveis(){
        return carroRepository.findByStatus(StatusCarro.DISPONIVEL);
    }

}
