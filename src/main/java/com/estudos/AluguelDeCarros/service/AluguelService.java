package com.estudos.AluguelDeCarros.service;

import com.estudos.AluguelDeCarros.dtos.AluguelDTO;
import com.estudos.AluguelDeCarros.entity.Aluguel;
import com.estudos.AluguelDeCarros.entity.Carro;
import com.estudos.AluguelDeCarros.entity.Cliente;
import com.estudos.AluguelDeCarros.enums.StatusAluguel;
import com.estudos.AluguelDeCarros.enums.StatusCarro;
import com.estudos.AluguelDeCarros.mapper.AluguelMapper;
import com.estudos.AluguelDeCarros.repository.AluguelRepository;
import com.estudos.AluguelDeCarros.repository.CarroRepository;
import com.estudos.AluguelDeCarros.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AluguelService {

    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;
    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    public AluguelService(
            ClienteRepository clienteRepository,
            CarroRepository carroRepository,
            AluguelRepository aluguelRepository,
            AluguelMapper aluguelMapper
    ) {
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
        this.aluguelRepository = aluguelRepository;
        this.aluguelMapper = aluguelMapper;
    }

    public Aluguel criarAluguel(AluguelDTO dto){
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Carro carro = carroRepository.findById(dto.getCarroId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        if(!carro.getStatus().equals(StatusCarro.DISPONIVEL)){
            throw new RuntimeException("Carro não está disponível para aluguel");
        }

        carro.setStatus(StatusCarro.ALUGADO);
        carroRepository.save(carro);

        Aluguel aluguel = aluguelMapper.toEntity(dto, cliente, carro);
        return aluguelRepository.save(aluguel);
    }

    public Aluguel finalizaAluguel(Long aluguelId){
        Aluguel aluguel = aluguelRepository.findById(aluguelId)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado."));

        if (aluguel.getStatusAluguel() != StatusAluguel.ATIVO){
            throw new RuntimeException("Este aluguel já foi finalizado.");
        }

        aluguel.setStatusAluguel(StatusAluguel.FINALIZADO);

        Carro carro = aluguel.getCarro();
        carro.setStatus(StatusCarro.DISPONIVEL);
        carroRepository.save(carro);

        return aluguelRepository.save(aluguel);
    }


}
