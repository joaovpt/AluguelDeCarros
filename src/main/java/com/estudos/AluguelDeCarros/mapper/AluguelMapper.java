package com.estudos.AluguelDeCarros.mapper;

import com.estudos.AluguelDeCarros.dtos.AluguelDTO;
import com.estudos.AluguelDeCarros.entity.Aluguel;
import com.estudos.AluguelDeCarros.entity.Carro;
import com.estudos.AluguelDeCarros.entity.Cliente;
import com.estudos.AluguelDeCarros.enums.StatusAluguel;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapper {

    public Aluguel toEntity(AluguelDTO dto, Cliente cliente, Carro carro) {
        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setCarro(carro);
        aluguel.setDataInicio(dto.getDataInicio());
        aluguel.setDataFim(dto.getDataFim());
        aluguel.setStatusAluguel(StatusAluguel.ATIVO);
        return aluguel;
    }

    public AluguelDTO toDTO(Aluguel aluguel) {
        AluguelDTO dto = new AluguelDTO();
        dto.setClienteId(aluguel.getCliente().getId());
        dto.setCarroId(aluguel.getCarro().getId());
        dto.setDataInicio(aluguel.getDataInicio());
        dto.setDataFim(aluguel.getDataFim());
        return dto;
    }
}
