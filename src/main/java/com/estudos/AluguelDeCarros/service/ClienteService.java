package com.estudos.AluguelDeCarros.service;

import com.estudos.AluguelDeCarros.entity.Cliente;
import com.estudos.AluguelDeCarros.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public void remove(Long id){
        this.clienteRepository.deleteById(id);
    }


}
