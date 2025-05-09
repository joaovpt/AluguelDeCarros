package com.estudos.AluguelDeCarros.mapper;

import com.estudos.AluguelDeCarros.dtos.ClienteDTO;
import com.estudos.AluguelDeCarros.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        return dto;
    }
}